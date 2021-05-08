package config

import (
	"fmt"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/yaml"
)

func (config Configuration) ConfigInit() error {
	config.ConfigYamlPath = GetConfigPath(config.Env)
	fmt.Println("Yaml Path: ", config.ConfigYamlPath)

	err := yaml.ReadYaml(config.ConfigYamlPath, &Config)
	if err != nil {
		fmt.Println("Assert读取文件失败: ", err)
		errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "初始化失败(yaml文件读取失败)")
	}
	fmt.Println("yaml config inside: ", Config)
	return nil
}

func GetConfigPath(env string) string {
	switch env {
	case "prod":
		fmt.Println("env: ", env)
		return "resource/config/conf_prod.yaml"
	case "dev":
		fmt.Println("env: ", env)
		return "resource/config/conf_dev.yaml"
	case "test":
		fmt.Println("env: ", env)
		return "resource/config/conf_test.yaml"
	default:
		fmt.Println("env: dev")
		return "resource/config/conf.yaml"
	}
}
