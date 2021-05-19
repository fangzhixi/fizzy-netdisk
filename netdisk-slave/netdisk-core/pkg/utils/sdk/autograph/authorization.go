package autograph

import (
	"fmt"
	"strconv"
	"strings"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
)

type Master struct {
	Algorithm string //加密规则
	Address   string //本机IP
	Nonce     int64  //6位随机数
	Timestamp int64  //时间戳
	MasterKey string //本机口令
}

/**
 * 主机签名验证(true通过,false不通过)[以MHAC-SHA-256解密方式为例]
 * Authorization按照以下方式排列: algorithm=解密方式,address=ip地址,nonce=随机数字(推荐6位),timestamp=过期时间戳master_key=主机认证口令
 * 样例: 				  algorithm=RSA-SHA256,address=192.168.0.1,nonce=169081,timestamp=1620454429master_key=KohIzIccGD6wNMnDCPeGf
 *
 * 加密后的Authorization格式:     Base64格式密码串
 * 样例:				  nft7AMsMTUguKohIzIccGD6wNMnDCPeGfxHMAEHmSfGA
 *                   	 |<---          Base64格式密码串           --->|
 *
 * 认证逻辑:
 * 1.将获取的原始从机口令字符串用Base64解码
 * 2.用密钥将从机口令解密
 * 3.比对从机认证口令与本机储存主机认证口令是否一致
 * 4.所有认证均符合则通过，反之则不通过*/
func (master *Master) MasterInvoice(authorization *string) (bool, error) {
	//数据验证
	if authorization == nil {
		return false, nil
	} else if len(*authorization) <= 0 {
		fmt.Println("authorization内容为空,校验不通过")
		return false, nil
	}

	fmt.Println("1.将获取的authorization原始字符串用Base64解码")
	fmt.Println("2.用密钥将authorization解密")
	message, err := RsaDecryptByBase64(authorization) //解密
	if err != nil {
		fmt.Println(err.Error())
		return false, nil
	} else if message == nil {
		fmt.Println("解密信息为空,校验不通过")
		return false, nil
	}
	fmt.Println("解密后的数据:", *message)

	fmt.Println("2-5.封装authorization信息")
	kVList := strings.Split(*message, ",")
	masterMap := make(map[string]string)
	for i := 0; i < len(kVList); i++ {
		kVItem := strings.Split(kVList[i], "=")
		if len(kVItem) == 2 {
			key := kVItem[0]
			value := kVItem[1]
			masterMap[key] = value
		} else {
			return false, nil
		}
	}

	fmt.Println("3.比对主机认证口令与本机储存主机认证口令是否一致")
	masterKey, err := GetMasterKey()
	if err != nil {
		fmt.Println(masterKey, "主机认证口令读取失败(文件不存在)")
		return false, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "主机认证口令读取失败(文件不存在)")
	}
	if masterKey != nil && *masterKey == masterMap["master_key"] {
		//封装数据
		nonce, err := strconv.ParseInt(masterMap["nonce"], 10, 64)
		if err != nil {
			return false, err
		}

		master.Algorithm = masterMap["algorithm"]
		master.Nonce = nonce
		master.MasterKey = masterMap["master_key"]
		return true, nil
	} else {
		return false, nil
	}
}

/**
 * 格式化输出
 *
 * @return signature
 */
func (master *Master) Format() *string {
	nonceStr := fmt.Sprintf("%d", master.Nonce)
	signature :=
		"algorithm=" + master.Algorithm +
			",address=" + master.Address +
			",nonce=" + nonceStr +
			",timestamp=" + fmt.Sprintf("%d", master.Timestamp) +
			",masterKey=" + master.MasterKey
	return &signature
}
