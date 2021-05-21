package config

import (
	"encoding/json"
	"errors"
	"fmt"
	"math/rand"
	"time"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/iodisk"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk/autograph"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/yaml"
)

func (config Configuration) ConfigInit() error {
	config.ConfigYamlPath = GetConfigPath(config.Env)
	fmt.Println("Yaml Path: ", config.ConfigYamlPath)

	err := yaml.ReadYaml(config.ConfigYamlPath, &Config)
	if err != nil {
		fmt.Println("Assert读取文件失败: ", err)
		errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "初始化失败(yaml文件读取失败)")
		return err
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

//发送主机注册请求
func SlaveRegister() (err error) {

	var size int64

	//1.数据初始化
	//1-1.获取本机监听地址
	ip, err := sdk.ExternalIP()
	if err != nil {
		fmt.Println(err)
		return err
	} else if len(Config.LocalConfig.Port) == 0 {
		errStr := "port number acquisition failed"
		fmt.Println(errStr)
		panic(errors.New(errStr))
	}
	address := ip.String() + Config.LocalConfig.Port
	//1-2.生成随机数
	rand.Seed(time.Now().UnixNano()) //利用当前时间的UNIX时间戳初始化rand包
	nonce := 100000 + rand.Intn(899999)
	//1-3.获取本机密钥
	masterKey, err := autograph.GetMasterKey()
	if err != nil {
		fmt.Println("获取口令失败: ", err)
		return err
	}

	master := &autograph.Master{Algorithm: "HMAC-SHA256",
		Address:   address,
		Nonce:     int64(nonce),
		Timestamp: time.Now().Unix(),
		MasterKey: *masterKey}

	//1-4.口令加密
	fmt.Println("master: ", *master.Format())
	signature, err := autograph.RsaEncryptOutBase64(master.Format()) //加密
	if err != nil {
		fmt.Println("主机注册请求口令加密失败: ", err.Error())
		return err
	}

	//2.初始化网盘托管目录
	//2-1.判断是否存在该目录
	if iodisk.IsDir(Config.LocalConfig.LocalPath) {
		//2-1-1.获取存储目录大小
		size, err = iodisk.DirSize(Config.LocalConfig.LocalPath)
		if err != nil {
			fmt.Println(err)
			return err
		}
	} else {
		//2-2-1.尚无目标目录,新建目录
		err = iodisk.Mkdir(Config.LocalConfig.LocalPath)
		if err != nil {
			fmt.Println(err)
			return err
		}
	}

	//3.请求Master主机注册服务
	//3-1.设置request body (json格式)
	body := []byte(fmt.Sprintf("totalSpace=%d&usedSpace=%d", Config.LocalConfig.TotalSpace, size))

	sdk := sdk.Sdk{BaseUrl: Config.RemoteConfig.Ip}
	rspBody, err := sdk.HttpPost("/slaveRegister",
		map[string]string{"Content-Type": "application/x-www-form-urlencoded", "Connection": "close", "Authorization": *signature},
		body)
	if err != nil {
		fmt.Println("主机注册响应失败", size)
		return err
	}

	rspMap := make(map[string]interface{})
	err = json.Unmarshal(rspBody, &rspMap)
	if err != nil {
		fmt.Println("json解析数据失败")
		return err
	}

	//4.存放UUID
	Config.RemoteConfig.UUID = rspMap["uuid"].(string)
	fmt.Println("rspMap", rspMap)
	fmt.Println("主机注册请求初始化结束: UUID: ", Config.RemoteConfig.UUID)
	return nil
}
