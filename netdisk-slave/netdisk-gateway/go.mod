module gateway

go 1.14

require (
	github.com/golang/protobuf v1.5.2
	github.com/grpc-ecosystem/grpc-gateway v1.16.0
	gitlab.yewifi.com/golden-cloud/common v0.8.1
	gitlab.yewifi.com/golden-cloud/protocol v0.0.0-20210421055830-e4e3da4f8db7
	golang.org/x/net v0.0.0-20210330075724-22f4162a9025
	google.golang.org/grpc v1.36.1
	gopkg.in/yaml.v2 v2.4.0
)

// replace gitlab.yewifi.com/golden-cloud/common => ../../common

// replace gitlab.yewifi.com/golden-cloud/protocol => ../../protocol
