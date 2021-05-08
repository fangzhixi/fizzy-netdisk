package config

import (
	"flag"
	"fmt"
	"io/ioutil"

	// "testing"
	"gopkg.in/yaml.v2"
)

var Config Conf

type Conf struct {
	Env         string `yaml:"env"`
	AppName     string `yaml:"app_name"`
	LogPath     string `yaml:"log_path"`
	LogLevel    uint32 `yaml:"log_level"`
	Mode        string `yaml:"mode"`
	SentryDsn   string `yaml:"sentry_dsn"`
	DbLogEnable bool   `yaml:"db_log_enable"`

	ApiGrpcUrl     string `yaml:"api_grpc_url"`
	GatewayUrl     string `yaml:"gateway_url"`
	JaegerAgentUri string `yaml:"jaeger_agent_uri"`
}

var gConfigName string

func init() {
	//testing.Init()
	fmt.Println("config init")
	flag.StringVar(&gConfigName, "conf", "./conf.yaml", "config name")
	flag.Parse()

	fmt.Println("config name ", gConfigName)

	ParseYaml(gConfigName, &Config)
}

func ParseYaml(file string, configRaw interface{}) {
	content, err := ioutil.ReadFile(file)
	if err != nil {
		panic("加载配置文件错误" + file + "错误原因" + err.Error())
	}

	err = yaml.Unmarshal(content, configRaw)
	if err != nil {
		panic("解析配置文件错误" + file + "错误原因" + err.Error())
	}
}
