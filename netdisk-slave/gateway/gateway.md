package gateway

import (
	"crypto/tls"
	"io/ioutil"
	"log"
	"net"
	"net/http"
	"strings"

	//"path"
	"github.com/grpc-ecosystem/grpc-gateway/runtime"
	"golang.org/x/net/context"
	"golang.org/x/net/http2"
	"google.golang.org/grpc"
	"google.golang.org/grpc/credentials"

	//"github.com/elazarl/go-bindata-assetfs"

	//pb "github.com/EDDYCJY/grpc-hello-world/proto"
	"tax-platform/imp"
	gw "tax-platform/protocol/inner"
	// "github.com/EDDYCJY/grpc-hello-world/pkg/util"
	// "github.com/EDDYCJY/grpc-hello-world/pkg/ui/data/swagger"
)

var (
	ServerPort     string
	CertServerName string
	CertPemPath    string
	CertKeyPath    string
	SwaggerDir     string
	EndPoint       string

	tlsConfig *tls.Config
)

func Run() (err error) {
	EndPoint = ":" + ServerPort
	tlsConfig = GetTLSConfig(CertPemPath, CertKeyPath)

	conn, err := net.Listen("tcp", EndPoint)
	if err != nil {
		log.Printf("TCP Listen err:%v\n", err)
	}

	srv := newServer(conn)

	log.Printf("gRPC and https listen on: %s\n", ServerPort)

	if err = srv.Serve(NewTLSListener(conn, tlsConfig)); err != nil {
		log.Printf("ListenAndServe: %v\n", err)
	}

	return err
}

func newServer(conn net.Listener) *http.Server {
	grpcServer := newGrpc()
	gwmux, err := newGateway()
	if err != nil {
		panic(err)
	}

	mux := http.NewServeMux()
	mux.Handle("/", gwmux)
	//mux.HandleFunc("/swagger/", serveSwaggerFile)
	// serveSwaggerUI(mux)

	return &http.Server{
		Addr:      EndPoint,
		Handler:   grpcHandlerFunc(grpcServer, mux),
		TLSConfig: tlsConfig,
	}
}

func newGrpc() *grpc.Server {
	creds, err := credentials.NewServerTLSFromFile(CertPemPath, CertKeyPath)
	if err != nil {
		panic(err)
	}

	opts := []grpc.ServerOption{
		grpc.Creds(creds),
	}

	server := grpc.NewServer(opts...)

	imp.RegisterHandler(server)
	return server
}

func newGateway() (http.Handler, error) {
	ctx := context.Background()
	dcreds, err := credentials.NewClientTLSFromFile(CertPemPath, CertServerName)
	if err != nil {
		return nil, err
	}
	dopts := []grpc.DialOption{grpc.WithTransportCredentials(dcreds)}

	gwmux := runtime.NewServeMux()
	if err := gw.RegisterInnerMethodHandlerFromEndpoint(ctx, gwmux, EndPoint, dopts); err != nil {
		return nil, err
	}

	return gwmux, nil
}

func grpcHandlerFunc(grpcServer *grpc.Server, otherHandler http.Handler) http.Handler {
	if otherHandler == nil {
		//logger.Info("11111110000")
		return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
			grpcServer.ServeHTTP(w, r)
		})
	}
	return http.HandlerFunc(func(w http.ResponseWriter, r *http.Request) {
		if r.ProtoMajor == 2 && strings.Contains(r.Header.Get("Content-Type"), "application/grpc") {
			//logger.Info("111111100001")
			grpcServer.ServeHTTP(w, r)
		} else {
			//logger.Info("111111100002")
			otherHandler.ServeHTTP(w, r)
		}
	})
}
func GetTLSConfig(certPemPath, certKeyPath string) *tls.Config {
	var certKeyPair *tls.Certificate
	cert, _ := ioutil.ReadFile(certPemPath)
	key, _ := ioutil.ReadFile(certKeyPath)

	pair, err := tls.X509KeyPair(cert, key)
	if err != nil {
		log.Println("TLS KeyPair err: %v\n", err)
	}

	certKeyPair = &pair

	return &tls.Config{
		Certificates: []tls.Certificate{*certKeyPair},
		NextProtos:   []string{http2.NextProtoTLS},
	}
}

func NewTLSListener(inner net.Listener, config *tls.Config) net.Listener {
	return tls.NewListener(inner, config)
}

// func serveSwaggerFile(w http.ResponseWriter, r *http.Request) {
//       if ! strings.HasSuffix(r.URL.Path, "swagger.json") {
//         log.Printf("Not Found: %s", r.URL.Path)
//         http.NotFound(w, r)
//         return
//     }

//     p := strings.TrimPrefix(r.URL.Path, "/swagger/")
//     p = path.Join(SwaggerDir, p)

//     log.Printf("Serving swagger-file: %s", p)

//     http.ServeFile(w, r, p)
// }

// func serveSwaggerUI(mux *http.ServeMux) {
//     fileServer := http.FileServer(&assetfs.AssetFS{
//         Asset:    swagger.Asset,
//         AssetDir: swagger.AssetDir,
//         Prefix:   "third_party/swagger-ui",
//     })
//     prefix := "/swagger-ui/"
//     mux.Handle(prefix, http.StripPrefix(prefix, fileServer))
// }
