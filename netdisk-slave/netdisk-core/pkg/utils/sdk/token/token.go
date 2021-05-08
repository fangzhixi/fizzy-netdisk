package token

import (
	"fmt"
	"strings"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
)

/**签名验证(true通过,false不通过)[只支持MHAC-SHA-256解密]
Token按照以下方式排列: userID=用户ID,nonce=随机数字(6位),timestamp=时间戳(10位),masterKey=主机认证口令
样例: 				  userID=17820478359,nonce=169081,timestamp=1620454429,masterKey=KohIzIccGD6wNMnDCPeGf

加密后的token格式:     Base64格式密码串
样例:				  nft7AMsMTUguKohIzIccGD6wNMnDCPeGfxHMAEHmSfGA
					 |<---          Base64格式密码串          --->|

认证逻辑:
	1.将获取的token原始字符串用Base64解码
	2.用密钥将token解密
	3.比对主机认证口令与本机储存主机认证口令是否一致
	4.所有认证均符合则通过，反之则不通过
*/
func TokenInvoice(token string) (bool, error) {
	if len(token) <= 0 {
		fmt.Println("Token内容为空,校验不通过")
		return false, nil
	}

	fmt.Println("1.将获取的token原始字符串用Base64解码")
	fmt.Println("2.用密钥将token解密")
	message, err := RsaDecryptByBase64(token) //解密
	if err != nil {
		fmt.Println(err.Error())
	} else if message == nil {
		fmt.Println("解密信息为空,校验不通过")
		return false, nil
	}
	fmt.Println("解密后的数据:", *message)

	fmt.Println("2-5.封装token信息")
	kVList := strings.Split(*message, ",")
	tokenMap := make(map[string]string)
	for i := 0; i < len(kVList); i++ {
		kVItem := strings.Split(kVList[i], "=")
		if len(kVItem) == 2 {
			key := kVItem[0]
			value := kVItem[1]
			tokenMap[key] = value
		} else {
			return false, nil
		}
	}

	fmt.Println("3.比对主机认证口令与本机储存主机认证口令是否一致")
	masterKey, err := getMasterKey()
	if err != nil {
		fmt.Println(masterKey, "主机认证口令读取失败(文件不存在)")
		return false, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "主机认证口令读取失败(文件不存在)")
	}
	if masterKey != nil && *masterKey == tokenMap["masterKey"] {
		return true, nil
	} else {
		return false, nil
	}
}
