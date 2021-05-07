package config

import (
	"fmt"

	"github.com/fangzhixi/netdisk-core/pkg/utils/yaml"
)

type Configuration struct {
	Env            string `yaml:"env"`
	AppName        string `yaml:"app_name"`
	LogLevel       uint32 `yaml:"log_level"`
	LogPath        string `yaml:"log_path"`
	ListenAddress  int    `yaml:"lesten_address"`
	PrivateKeyPath string `yaml:"private_key_path"`
	PublicKeyPath  string `yaml:"private_key_path"`
	RootPathName   string `yaml:"root_path_name"`
}

func NewconfigFile(path string) configFile {
	return configFile{}
}

type configFile struct {
	Path string
}

func (config configFile) ConfigInit() {
	configuration := Configuration{}
	yaml.ReadYaml(config.Path, Configuration{})
	fmt.Println(configuration)
}

func (config configFile) getEnv() string {
	switch config.Path {
	case "prud":
		fmt.Println("启动环境: ", config)
		return "./config/conf_prud.yaml"
	case "env":
		fmt.Println("启动环境: ", config)
		return "./config/conf_env.yaml"
	case "test":
		fmt.Println("启动环境: ", config)
		return "./config/conf_test.yaml"
	default:
		fmt.Println("启动环境: env")
		return "./config/conf.yaml"
	}
}
