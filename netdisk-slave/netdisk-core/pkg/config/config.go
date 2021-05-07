package config

import (
	"flag"
	"fmt"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/yaml"
)

var (
	LogID  string
	Config Configuration
)

type Configuration struct {
	ConfigYamlPath string
	Env            string `yaml:"env"`
	AppName        string `yaml:"app_name"`
	LogPath        string `yaml:"log_path"`
	LogLevel       uint32 `yaml:"log_level"`
	ListenAddress  int    `yaml:"listen_address"`
	PublicKeyPath  string `yaml:"public_key_path"`
	PrivateKeyPath string `yaml:"private_key_path"`
	RootPathName   string `yaml:"root_path_name"`
	RemoteConfig   struct {
		Ip    string `yaml:"ip"`
		Port  int8   `yaml:"port"`
		Group string `yaml:"group"`
	} `yaml:"remote_conf"`
}

func Newconfig(path string) Configuration {
	return Configuration{ConfigYamlPath: path}
}

func (config Configuration) ConfigInit() error {
	LogID = "123321321"
	fmt.Println("Yaml Path: ", config.ConfigYamlPath)
	err := yaml.ReadYaml(config.ConfigYamlPath, &Config)
	if err != nil {
		return errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "yaml读取失败")
	}
	fmt.Println("config.Configuration: ", Config)
	return nil
}

func FlagInit() map[string]string {

	configFilePath := flag.String("env", "dev", "123")
	flag.Parse()

	flagMap := make(map[string]string)
	flagMap["configYamlPath"] = *configFilePath
	fmt.Println("flag: ", flagMap)
	return flagMap
}

func GetConfigPath(env string) string {
	switch env {
	case "prod":
		fmt.Println("启动环境: ", env)
		return "./config/conf_prod.yaml"
	case "dev":
		fmt.Println("启动环境: ", env)
		return "./config/conf_env.yaml"
	case "test":
		fmt.Println("启动环境: ", env)
		return "./config/conf_test.yaml"
	default:
		fmt.Println("启动环境: dev")
		return "./config/conf.yaml"
	}
}
