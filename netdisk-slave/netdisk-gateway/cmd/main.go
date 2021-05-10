package main

import (
	//"context"
	"fmt"
	"gateway/config"
	"io"
	"net/http"
	"net/textproto"
	"strconv"
	"strings"

	"google.golang.org/grpc/connectivity"

	"github.com/golang/protobuf/proto"
	"github.com/grpc-ecosystem/grpc-gateway/runtime"
	gwruntime "github.com/grpc-ecosystem/grpc-gateway/runtime"

	// "gitlab.yewifi.com/golden-cloud/common/tracer"

	apipb "github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/grpc"
	"golang.org/x/net/context"
	"google.golang.org/grpc"
	"google.golang.org/grpc/codes"
	"google.golang.org/grpc/status"
)

type contentTypeMarshaler interface {
	ContentTypeFromMessage(v interface{}) string
}

type Error struct {
	Message string `json:"message"`
	Code    int32  `json:"code"`
}

const MetadataTrailerPrefix = "Grpc-Trailer-"
const MetadataHeaderPrefix = "Grpc-Metadata-"

// allowCORS allows Cross Origin Resoruce Sharing from any origin.
// Don't do this without consideration in production systems.
func allowCORS(h http.Handler) http.Handler {
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		if origin := r.Header.Get("Origin"); origin != "" {
			w.Header().Set("Access-Control-Allow-Origin", origin)
			if r.Method == "OPTIONS" && r.Header.Get("Access-Control-Request-Method") != "" {
				preflightHandler(w, r)
				return
			}
		}
		h.ServeHTTP(w, r)
	})
}

// preflightHandler adds the necessary headers in order to serve
// CORS from any origin using the methods "GET", "HEAD", "POST", "PUT", "DELETE"
// We insist, don't do this without consideration in production systems.
func preflightHandler(w http.ResponseWriter, r *http.Request) {
	headers := []string{"Content-Type", "Accept", "Authorization", "Access-Token"}
	w.Header().Add("Access-Control-Allow-Headers", strings.Join(headers, ","))
	methods := []string{"GET", "HEAD", "POST", "PUT", "DELETE"}
	w.Header().Set("Access-Control-Allow-Methods", strings.Join(methods, ","))
	fmt.Printf("preflight request for %s \n", r.URL.Path)
}

func customMatcher(key string) (string, bool) {
	switch key {
	case "Appkey":
		return key, true
	case "Access-Token":
		return key, true
	case "Uber-Trace-Id":
		return key, true
	default:
		return runtime.DefaultHeaderMatcher(key)
	}
}

func filter(gwHandler http.Handler) http.HandlerFunc {

	return func(w http.ResponseWriter, r *http.Request) {
		//调用链记录
		span := tracer.GatewayStart(r, r.RequestURI)
		defer span.Finish()

		fmt.Println("pre filter: ", r.Method, "url", r.URL)
		gwHandler.ServeHTTP(w, r)
		fmt.Println("after filter: ", r.Method, "url", r.URL)
	}
}

// newGateway returns a new gateway server which translates HTTP into gRPC.
func newGateway(ctx context.Context, conn *grpc.ClientConn, opts []gwruntime.ServeMuxOption) (http.Handler, error) {
	mux := gwruntime.NewServeMux(opts...)
	// ctx context.Context, mux *runtime.ServeMux, conn *grpc.ClientConn
	err := apipb.RegisterInputBizApiHandler(ctx, mux, conn)
	if err != nil {
		fmt.Println("注册服务失败:", err, config.Config.GatewayUrl)
		return mux, err
	}
	if conn == nil {
		fmt.Println("conn1.6 is nil!")
	}
	return mux, nil
}
func endFilter(ctx context.Context, w http.ResponseWriter, rsp proto.Message) error {
	fmt.Println("rsp content: ", rsp.String())
	return nil
}

func handleForwardResponseServerMetadata(w http.ResponseWriter, md gwruntime.ServerMetadata) {
	for k, vs := range md.HeaderMD {
		h := fmt.Sprintf("%s%s", MetadataHeaderPrefix, k)
		for _, v := range vs {
			w.Header().Add(h, v)
		}
	}
}

func handleForwardResponseTrailerHeader(w http.ResponseWriter, md gwruntime.ServerMetadata) {
	for k := range md.TrailerMD {
		tKey := textproto.CanonicalMIMEHeaderKey(fmt.Sprintf("%s%s", MetadataTrailerPrefix, k))
		w.Header().Add("Trailer", tKey)
	}
}

func handleForwardResponseTrailer(w http.ResponseWriter, md gwruntime.ServerMetadata) {
	for k, vs := range md.TrailerMD {
		tKey := fmt.Sprintf("%s%s", MetadataTrailerPrefix, k)
		for _, v := range vs {
			w.Header().Add(tKey, v)
		}
	}
}

func HTTPError(ctx context.Context, mux *gwruntime.ServeMux, marshaler gwruntime.Marshaler, w http.ResponseWriter, _ *http.Request, err error) {
	const fallback = `{"error": "failed to marshal error message"}`

	s, ok := status.FromError(err)
	if !ok {
		s = status.New(codes.Unknown, err.Error())
	}

	httpFlag := false
	errMsg := s.Message()
	if pos := strings.LastIndex(errMsg, "-"); pos > -1 {
		strCode := errMsg[pos+1 : len(errMsg)]
		if code, err := strconv.Atoi(strCode); err == nil {
			errMsg = errMsg[0:pos]
			s = status.New(codes.Code(code), errMsg)
			httpFlag = true
		}
	}

	w.Header().Del("Trailer")

	contentType := marshaler.ContentType()
	// Check marshaler on run time in order to keep backwards compatability
	// An interface param needs to be added to the ContentType() function on
	// the Marshal interface to be able to remove this check
	if typeMarshaler, ok := marshaler.(contentTypeMarshaler); ok {
		pb := s.Proto()
		contentType = typeMarshaler.ContentTypeFromMessage(pb)
	}
	w.Header().Set("Content-Type", contentType)

	body := Error{
		Message: s.Message(),
		Code:    int32(s.Code()),
	}

	buf, merr := marshaler.Marshal(body)
	if merr != nil {
		fmt.Printf("Failed to marshal error message %q: %v", body, merr)
		w.WriteHeader(http.StatusInternalServerError)
		if _, err := io.WriteString(w, fallback); err != nil {
			fmt.Printf("Failed to write response: %v", err)
		}
		return
	}

	md, ok := gwruntime.ServerMetadataFromContext(ctx)
	if !ok {
		fmt.Println("Failed to extract ServerMetadata from context")
	}

	handleForwardResponseServerMetadata(w, md)
	handleForwardResponseTrailerHeader(w, md)
	st := gwruntime.HTTPStatusFromCode(s.Code())
	if httpFlag {
		if int(s.Code()) == int(http.StatusUnauthorized) { //用户登录状态返回401
			w.WriteHeader(http.StatusUnauthorized)
		} else {
			w.WriteHeader(http.StatusOK)
		}
	} else {
		w.WriteHeader(st)
	}

	if _, err := w.Write(buf); err != nil {
		fmt.Printf("Failed to write response: %v", err)
	}

	handleForwardResponseTrailer(w, md)
}

// initTracer 调用链初始化
func initTracer() {
	span, _, err := tracer.NewJaegerTracer(config.Config.AppName, config.Config.JaegerAgentUri)
	if err != nil || span == nil {
		fmt.Println("Failed to init tracer: ", err)
	}
}

// healthzServer returns a simple health handler which returns ok.
func healthzServer(conn *grpc.ClientConn) http.HandlerFunc {
	return func(w http.ResponseWriter, r *http.Request) {
		w.Header().Set("Content-Type", "text/plain")
		if s := conn.GetState(); s != connectivity.Ready {
			http.Error(w, fmt.Sprintf("grpc server is %s", s), http.StatusBadGateway)
			return
		}
		fmt.Fprintln(w, "ok")
	}
}

func main() {
	initTracer() //调用链初始化

	gwruntime.GlobalHTTPErrorHandler = HTTPError

	ctx := context.Background()
	ctx, cancel := context.WithCancel(ctx)
	defer cancel()
	conn, err := grpc.DialContext(ctx, config.Config.ApiGrpcUrl, grpc.WithInsecure(), tracer.GrpcGatewayDialOption())
	if err != nil {
		return
	}

	go func() {
		<-ctx.Done()
		if err := conn.Close(); err != nil {
			fmt.Printf("Failed to close a client connection to the gRPC server: %v", err)
		}
	}()

	fmt.Println("监听地址:", config.Config.ApiGrpcUrl)

	mux := http.NewServeMux()
	var originMux []gwruntime.ServeMuxOption
	originMux = append(originMux, gwruntime.WithMarshalerOption(gwruntime.MIMEWildcard, &gwruntime.JSONPb{OrigName: true, EmitDefaults: true}))
	originMux = append(originMux, gwruntime.WithForwardResponseOption(endFilter))
	originMux = append(originMux, gwruntime.WithIncomingHeaderMatcher(customMatcher))
	gwMux, err := newGateway(ctx, conn, originMux)
	if err != nil {
		return
	}
	mux.Handle("/", filter(gwMux))
	//新增健康检查
	mux.HandleFunc("/healthz", healthzServer(conn))

	s := &http.Server{
		Addr:    config.Config.GatewayUrl,
		Handler: allowCORS(mux),
	}
	go func() {
		<-ctx.Done()
		fmt.Println("Shutting down the http server")
		if err := s.Shutdown(context.Background()); err != nil {
			fmt.Printf("Failed to shutdown http server: %v", err)
		}
	}()

	fmt.Printf("Starting listening at %s", config.Config.GatewayUrl)
	if err := s.ListenAndServe(); err != http.ErrServerClosed {
		fmt.Printf("Failed to listen and serve: %v", err)
		return
	}
	return

}
