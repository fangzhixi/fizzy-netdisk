package config

import (
	"flag"
	"fmt"

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

func Newconfig(yamlPath string) Configuration {
	LogID = "123321321"
	return Configuration{ConfigYamlPath: yamlPath}
}

func (config Configuration) ConfigInit() error {
	fmt.Println("Yaml Path: ", config.ConfigYamlPath)
	err := yaml.ReadYaml(config.ConfigYamlPath, &Config)
	if err != nil {
		fmt.Println("Assert读取文件失败: ", err)
		panic(err)
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
		return "resource/config/conf_prod.yaml"
	case "dev":
		fmt.Println("启动环境: ", env)
		return "resource/config/conf_dev.yaml"
	case "test":
		fmt.Println("启动环境: ", env)
		return "resource/config/conf_test.yaml"
	default:
		fmt.Println("启动环境: dev")
		return "resource/config/conf.yaml"
	}
}
