// Code generated by protoc-gen-go. DO NOT EDIT.
// versions:
// 	protoc-gen-go v1.24.0
// 	protoc        v3.15.6
// source: fizzy_netdisk_api.proto

package services

import (
	proto "github.com/golang/protobuf/proto"
	_ "google.golang.org/genproto/googleapis/api/annotations"
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
	0x61, 0x70, 0x69, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x12, 0x08, 0x73, 0x65, 0x72, 0x76, 0x69,
	0x63, 0x65, 0x73, 0x1a, 0x11, 0x61, 0x6e, 0x6e, 0x6f, 0x74, 0x61, 0x74, 0x69, 0x6f, 0x6e, 0x73,
	0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x1a, 0x13, 0x66, 0x69, 0x7a, 0x7a, 0x79, 0x5f, 0x6e, 0x65,
	0x74, 0x64, 0x69, 0x73, 0x6b, 0x2e, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x32, 0xca, 0x01, 0x0a, 0x14,
	0x46, 0x69, 0x7a, 0x7a, 0x79, 0x4e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x53, 0x6c, 0x61, 0x76,
	0x65, 0x41, 0x70, 0x69, 0x12, 0x54, 0x0a, 0x06, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x12, 0x13,
	0x2e, 0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x73, 0x2e, 0x55, 0x70, 0x6c, 0x6f, 0x61, 0x64,
	0x52, 0x65, 0x71, 0x1a, 0x13, 0x2e, 0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x73, 0x2e, 0x55,
	0x70, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x73, 0x70, 0x22, 0x20, 0x82, 0xd3, 0xe4, 0x93, 0x02, 0x1a,
	0x22, 0x15, 0x2f, 0x66, 0x69, 0x7a, 0x7a, 0x79, 0x2d, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b,
	0x2f, 0x75, 0x70, 0x6c, 0x6f, 0x61, 0x64, 0x3a, 0x01, 0x2a, 0x12, 0x5c, 0x0a, 0x08, 0x44, 0x6f,
	0x77, 0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x12, 0x15, 0x2e, 0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65,
	0x73, 0x2e, 0x44, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x52, 0x65, 0x71, 0x1a, 0x15, 0x2e,
	0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x73, 0x2e, 0x44, 0x6f, 0x77, 0x6e, 0x6c, 0x6f, 0x61,
	0x64, 0x52, 0x73, 0x70, 0x22, 0x22, 0x82, 0xd3, 0xe4, 0x93, 0x02, 0x1c, 0x22, 0x17, 0x2f, 0x66,
	0x69, 0x7a, 0x7a, 0x79, 0x2d, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x2f, 0x64, 0x6f, 0x77,
	0x6e, 0x6c, 0x6f, 0x61, 0x64, 0x3a, 0x01, 0x2a, 0x42, 0x25, 0x0a, 0x14, 0x63, 0x6f, 0x6d, 0x2e,
	0x66, 0x69, 0x7a, 0x7a, 0x79, 0x2e, 0x6e, 0x65, 0x74, 0x64, 0x69, 0x73, 0x6b, 0x2e, 0x70, 0x62,
	0x50, 0x01, 0x5a, 0x0b, 0x2f, 0x2e, 0x3b, 0x73, 0x65, 0x72, 0x76, 0x69, 0x63, 0x65, 0x73, 0x62,
	0x06, 0x70, 0x72, 0x6f, 0x74, 0x6f, 0x33,
}

var file_fizzy_netdisk_api_proto_goTypes = []interface{}{
	(*UploadReq)(nil),   // 0: services.UploadReq
	(*DownloadReq)(nil), // 1: services.DownloadReq
	(*UploadRsp)(nil),   // 2: services.UploadRsp
	(*DownloadRsp)(nil), // 3: services.DownloadRsp
}
var file_fizzy_netdisk_api_proto_depIdxs = []int32{
	0, // 0: services.FizzyNetdiskSlaveApi.Upload:input_type -> services.UploadReq
	1, // 1: services.FizzyNetdiskSlaveApi.Download:input_type -> services.DownloadReq
	2, // 2: services.FizzyNetdiskSlaveApi.Upload:output_type -> services.UploadRsp
	3, // 3: services.FizzyNetdiskSlaveApi.Download:output_type -> services.DownloadRsp
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
