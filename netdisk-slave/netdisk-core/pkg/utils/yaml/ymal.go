package yaml

import (
	"io/ioutil"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"gopkg.in/yaml.v2"
)

func ReadYaml(yamlPath string, bean interface{}) error {
	bytes, err := ioutil.ReadFile(yamlPath)
	if err != nil {
		return errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "yaml读取失败(文件不存在)")
	}
	err = yaml.Unmarshal(bytes, bean)
	if err != nil {
		return errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "yaml读取失败(yaml.Unmarshal转义失败)")
	}
	return nil
}
