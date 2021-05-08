package config

import (
	"flag"
	"fmt"
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

func Newconfig(env string) Configuration {
	LogID = "123321321"
	Config = Configuration{Env: env}
	return Config
}

func FlagInit() map[string]string {
	env := flag.String("env", "dev", "123")
	flag.Parse()

	flagMap := make(map[string]string)
	flagMap["env"] = *env
	fmt.Println("flag: ", flagMap)
	return flagMap
}
