package main

import (
	"fmt"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/config"
)

func main() {

	flagMap := config.FlagInit()
	configFilePath := flagMap["configYamlPath"]
	fmt.Println("configYamlPath: ", configFilePath)

	fmt.Println("\nconfigPath: ", flagMap["configYamlPath"])
	config.GetConfigPath(flagMap["configYamlPath"])

	err := config.Newconfig(flagMap["configYamlPath"]).ConfigInit()
	if err != nil {
		fmt.Println("初始化失败: ", err)
		panic(err)
	}
	fmt.Println("服务已启动", config.Config)

	fmt.Println("Hello World!")
}
