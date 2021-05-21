package main

import (
	"errors"
	"fmt"
	"net/http"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-api/imp"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/config"
)

func main() {

	flagMap := config.FlagInit()

	fmt.Println("initialize...")
	err := config.Newconfig(flagMap["env"]).ConfigInit()
	if err != nil {
		fmt.Println("initialize failed: ", err)
		panic(err)
	}
	fmt.Println("Request host registration...")
	err = config.SlaveRegister()
	if err != nil {
		fmt.Println("Request host registration failed(主机注册请求被拒绝) ", err)
		panic(err)
	}

	fmt.Println("server is starting...")
	port := config.Config.LocalConfig.Port
	if len(port) == 0 {
		errStr := "port number acquisition failed"
		fmt.Println(errStr)
		panic(errors.New(errStr))
	}
	fmt.Println("server listening port is: ", port)
	fmt.Println("all initialize was finish!")
	fmt.Println("Hello World!")

	http.HandleFunc("/download", imp.DownloadHandler)
	http.HandleFunc("/upload", imp.UploadHandler)
	http.ListenAndServe(port, nil)

}
