package main

import (
	"fmt"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/config"
)

func main() {

	flagMap := config.FlagInit()

	err := config.Newconfig(flagMap["env"]).ConfigInit()
	if err != nil {
		fmt.Println("初始化失败: ", err)
		panic(err)
	}
	err = config.SlaveRegister()
	if err != nil {
		fmt.Println("初始化失败(主机注册请求被拒绝) ", err)
		panic(err)
	}
	fmt.Println("")
	fmt.Println("server is starting...")
	fmt.Println("Hello World!")

}
