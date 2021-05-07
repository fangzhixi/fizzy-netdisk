package main

import (
	"flag"
	"fmt"

	"github.com/fangzhixi/netdisk-core/internal/config"
)

func FlagInit() (flagMap map[string]string) {
	flagMap = make(map[string]string)

	configFilePath := flag.String("env", "./config/conf.yaml", "指定运行环境")
	flag.Parse()

	flagMap["configFilePath"] = *configFilePath
	fmt.Println("flag: ", flagMap)
	return
}

func main() {

	FlagInit()
	config.ConfigInit()
	fmt.Println("服务已启动")
}
