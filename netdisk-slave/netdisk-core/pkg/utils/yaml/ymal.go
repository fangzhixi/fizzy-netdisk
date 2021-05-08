package yaml

import (
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/bindata"
	"gopkg.in/yaml.v2"
)

func ReadYaml(yamlPath string, bean interface{}) error {
	bytes, err := bindata.Asset(yamlPath)
	if err != nil {
		return errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "yaml读取失败(文件不存在)")
	}
	err = yaml.Unmarshal(bytes, bean)
	if err != nil {
		return errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "yaml读取失败(yaml.Unmarshal转义失败)")
	}
	return nil
}
