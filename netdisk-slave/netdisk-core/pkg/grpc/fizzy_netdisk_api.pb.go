// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.24.0
// 	protoc        v3.15.6
// source: fizzy_netdisk_api.proto

package grpc

import (
	context "context"
	proto "github.com/golang/protobuf/proto"
	_ "google.golang.org/genproto/googleapis/api/annotations"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	protoreflect "google.golang.org/protobuf/reflect/protoreflect"
	protoimpl "google.golang.org/protobuf/runtime/protoimpl"
	reflect "reflect"
)

const (
	// Verify that this generated code is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(20 - protoimpl.MinVersion)
	// Verify that runtime/protoimpl is sufficiently up-to-date.
	_ = protoimpl.EnforceVersion(protoimpl.MaxVersion - 20)
)

// This is a compile-time assertion that a sufficiently up-to-date version
// of the legacy proto package is being used.
const _ = proto.ProtoPackageIsVersion4

var File_fizzy_netdisk_api_proto protoreflect.FileDescriptor

var file_fizzy_netdisk_api_proto_rawDesc = []byte{
	0x0a, 0x17, 0x66, 0x69, 0x7a, 0x7a, 0x79, 0x5f, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x5f,
	0x61, 0x70, 0x69, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x04, 0x67, 0x72, 0x70, 0x63, 0x1a,
	0x11, 0x61, 0x6e, 0x6e, 0x6f, 0x74, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x73, 0x2e, 0x70, 0x72, 0x6f,
	0x74, 0x6f, 0x1a, 0x13, 0x66, 0x69, 0x7a, 0x7a, 0x79, 0x5f, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73,
	0x6b, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x32, 0xba, 0x01, 0x0a, 0x14, 0x46, 0x69, 0x7a, 0x7a,
	0x79, 0x4e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x53, 0x6c, 0x61, 0x76, 0x65, 0x41, 0x70, 0x69,
	0x12, 0x4c, 0x0a, 0x06, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x12, 0x0f, 0x2e, 0x67, 0x72, 0x70,
	0x63, 0x2e, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x65, 0x71, 0x1a, 0x0f, 0x2e, 0x67, 0x72,
	0x70, 0x63, 0x2e, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x73, 0x70, 0x22, 0x20, 0x82, 0xd3,
	0xe4, 0x93, 0x02, 0x1a, 0x22, 0x15, 0x2f, 0x66, 0x69, 0x7a, 0x7a, 0x79, 0x2d, 0x6e, 0x65, 0x74,
	0x64, 0x69, 0x73, 0x6b, 0x2f, 0x75, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x3a, 0x01, 0x2a, 0x12, 0x54,
	0x0a, 0x08, 0x44, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x12, 0x11, 0x2e, 0x67, 0x72, 0x70,
	0x63, 0x2e, 0x44, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x65, 0x71, 0x1a, 0x11, 0x2e,
	0x67, 0x72, 0x70, 0x63, 0x2e, 0x44, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x73, 0x70,
	0x22, 0x22, 0x82, 0xd3, 0xe4, 0x93, 0x02, 0x1c, 0x22, 0x17, 0x2f, 0x66, 0x69, 0x7a, 0x7a, 0x79,
	0x2d, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x2f, 0x64, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61,
	0x64, 0x3a, 0x01, 0x2a, 0x42, 0x1b, 0x0a, 0x0e, 0x63, 0x6f, 0x6d, 0x2e, 0x66, 0x69, 0x7a, 0x7a,
	0x79, 0x2e, 0x67, 0x72, 0x70, 0x63, 0x50, 0x01, 0x5a, 0x07, 0x2f, 0x2e, 0x3b, 0x67, 0x72, 0x70,
	0x63, 0x62, 0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var file_fizzy_netdisk_api_proto_goTypes = []interface{}{
	(*UploadReq)(nil),   // 0: grpc.UploadReq
	(*DownloadReq)(nil), // 1: grpc.DownloadReq
	(*UploadRsp)(nil),   // 2: grpc.UploadRsp
	(*DownloadRsp)(nil), // 3: grpc.DownloadRsp
}
var file_fizzy_netdisk_api_proto_depIdxs = []int32{
	0, // 0: grpc.FizzyNetdiskSlaveApi.Upload:input_type -> grpc.UploadReq
	1, // 1: grpc.FizzyNetdiskSlaveApi.Download:input_type -> grpc.DownloadReq
	2, // 2: grpc.FizzyNetdiskSlaveApi.Upload:output_type -> grpc.UploadRsp
	3, // 3: grpc.FizzyNetdiskSlaveApi.Download:output_type -> grpc.DownloadRsp
	2, // [2:4] is the sub-list for method output_type
	0, // [0:2] is the sub-list for method input_type
	0, // [0:0] is the sub-list for extension type_name
	0, // [0:0] is the sub-list for extension extendee
	0, // [0:0] is the sub-list for field type_name
}

func init() { file_fizzy_netdisk_api_proto_init() }
func file_fizzy_netdisk_api_proto_init() {
	if File_fizzy_netdisk_api_proto != nil {
		return
	}
	file_fizzy_netdisk_proto_init()
	type x struct{}
	out := protoimpl.TypeBuilder{
		File: protoimpl.DescBuilder{
			GoPackagePath: reflect.TypeOf(x{}).PkgPath(),
			RawDescriptor: file_fizzy_netdisk_api_proto_rawDesc,
			NumEnums:      0,
			NumMessages:   0,
			NumExtensions: 0,
			NumServices:   1,
		},
		GoTypes:           file_fizzy_netdisk_api_proto_goTypes,
		DependencyIndexes: file_fizzy_netdisk_api_proto_depIdxs,
	}.Build()
	File_fizzy_netdisk_api_proto = out.File
	file_fizzy_netdisk_api_proto_rawDesc = nil
	file_fizzy_netdisk_api_proto_goTypes = nil
	file_fizzy_netdisk_api_proto_depIdxs = nil
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConnInterface

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion6

// FizzyNetdiskSlaveApiClient is the client API for FizzyNetdiskSlaveApi service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type FizzyNetdiskSlaveApiClient interface {
	Upload(ctx context.Context, in *UploadReq, opts ...grpc.CallOption) (*UploadRsp, error)
	Download(ctx context.Context, in *DownloadReq, opts ...grpc.CallOption) (*DownloadRsp, error)
}

type fizzyNetdiskSlaveApiClient struct {
	cc grpc.ClientConnInterface
}

func NewFizzyNetdiskSlaveApiClient(cc grpc.ClientConnInterface) FizzyNetdiskSlaveApiClient {
	return &fizzyNetdiskSlaveApiClient{cc}
}

func (c *fizzyNetdiskSlaveApiClient) Upload(ctx context.Context, in *UploadReq, opts ...grpc.CallOption) (*UploadRsp, error) {
	out := new(UploadRsp)
	err := c.cc.Invoke(ctx, "/grpc.FizzyNetdiskSlaveApi/Upload", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *fizzyNetdiskSlaveApiClient) Download(ctx context.Context, in *DownloadReq, opts ...grpc.CallOption) (*DownloadRsp, error) {
	out := new(DownloadRsp)
	err := c.cc.Invoke(ctx, "/grpc.FizzyNetdiskSlaveApi/Download", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// FizzyNetdiskSlaveApiServer is the server API for FizzyNetdiskSlaveApi service.
type FizzyNetdiskSlaveApiServer interface {
	Upload(context.Context, *UploadReq) (*UploadRsp, error)
	Download(context.Context, *DownloadReq) (*DownloadRsp, error)
}

// UnimplementedFizzyNetdiskSlaveApiServer can be embedded to have forward compatible implementations.
type UnimplementedFizzyNetdiskSlaveApiServer struct {
}

func (*UnimplementedFizzyNetdiskSlaveApiServer) Upload(context.Context, *UploadReq) (*UploadRsp, error) {
	return nil, status.Errorf(codes.Unimplemented, "method Upload not implemented")
}
func (*UnimplementedFizzyNetdiskSlaveApiServer) Download(context.Context, *DownloadReq) (*DownloadRsp, error) {
	return nil, status.Errorf(codes.Unimplemented, "method Download not implemented")
}

func RegisterFizzyNetdiskSlaveApiServer(s *grpc.Server, srv FizzyNetdiskSlaveApiServer) {
	s.RegisterService(&_FizzyNetdiskSlaveApi_serviceDesc, srv)
}

func _FizzyNetdiskSlaveApi_Upload_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(UploadReq)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(FizzyNetdiskSlaveApiServer).Upload(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/grpc.FizzyNetdiskSlaveApi/Upload",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(FizzyNetdiskSlaveApiServer).Upload(ctx, req.(*UploadReq))
	}
	return interceptor(ctx, in, info, handler)
}

func _FizzyNetdiskSlaveApi_Download_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(DownloadReq)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(FizzyNetdiskSlaveApiServer).Download(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/grpc.FizzyNetdiskSlaveApi/Download",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(FizzyNetdiskSlaveApiServer).Download(ctx, req.(*DownloadReq))
	}
	return interceptor(ctx, in, info, handler)
}

var _FizzyNetdiskSlaveApi_serviceDesc = grpc.ServiceDesc{
	ServiceName: "grpc.FizzyNetdiskSlaveApi",
	HandlerType: (*FizzyNetdiskSlaveApiServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "Upload",
			Handler:    _FizzyNetdiskSlaveApi_Upload_Handler,
		},
		{
			MethodName: "Download",
			Handler:    _FizzyNetdiskSlaveApi_Download_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "fizzy_netdisk_api.proto",
}
