package token

import (
	"crypto/rand"
	"crypto/rsa"
	"crypto/x509"
	"encoding/base64"
	"encoding/pem"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errcode"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/error/errtype"
	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/bindata"
)

// 通过openssl产生2048位私钥
//openssl genrsa -out private.key 2048

//openssl根据私钥生成公钥文件
//openssl rsa -in rsa_private_key.pem -pubout -out public.key

// 加密
func RsaEncryptOutBase64(origData []byte) (*string, error) {
	//解密pem格式的公钥
	publicKeyByte, err := getPublicKey()
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "公钥获取失败(文件不存在)")
	} else if publicKeyByte == nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "公钥不可用(公钥内容为空)")
	}
	block, _ := pem.Decode(*publicKeyByte)
	if block == nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "公钥不可用(公钥格式不符合业务需求)")
	}
	// 解析公钥
	pubInterface, err := x509.ParsePKIXPublicKey(block.Bytes)
	if err != nil {
		return nil, err
	}
	// 类型断言
	pub := pubInterface.(*rsa.PublicKey)
	//加密
	bytes, err := rsa.EncryptPKCS1v15(rand.Reader, pub, origData)
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "加密失败")
	}
	base64 := base64.StdEncoding.EncodeToString(bytes)
	return &base64, nil
}

// 解密
func RsaDecryptByBase64(cipherBase64 string) (*string, error) {
	//解密
	privateKeyByte, err := getPrivateKey()
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "私钥获取失败(文件不存在)")
	} else if privateKeyByte == nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "私钥不可用(公钥内容为空)")
	}
	block, _ := pem.Decode(*privateKeyByte)
	if block == nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "私钥不可用(私钥格式不符合业务需求)")
	}
	//解析PKCS1格式的私钥
	priv, err := x509.ParsePKCS1PrivateKey(block.Bytes)
	if err != nil {
		return nil, err
	}
	// 解密
	ciphertext, err := base64.StdEncoding.DecodeString(cipherBase64)
	if err != nil {
		errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "base64转义失败")
	}

	bytes, err := rsa.DecryptPKCS1v15(rand.Reader, priv, ciphertext)
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "解码失败")
	}
	message := string(bytes)
	return &message, nil
}

//读取公钥文件
func getPublicKey() (*[]byte, error) {
	publicKeyPath := "resource/keystore/public.key"
	bytes, err := bindata.Asset(publicKeyPath)
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "公钥读取失败(文件不存在)")
	}
	return &bytes, nil
}

//读取私钥文件
func getPrivateKey() (*[]byte, error) {
	privateKeyPath := "resource/keystore/private.key"
	bytes, err := bindata.Asset(privateKeyPath)
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "私钥读取失败(文件不存在)")
	}
	return &bytes, nil
}

/**读取主机认证私钥文件
此文件用来认证是否为主服务器发出来的信息
*/
func getMasterKey() (*string, error) {
	masterKeyPath := "resource/keystore/master-attestation.key"
	bytes, err := bindata.Asset(masterKeyPath)
	if err != nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "主机认证私钥读取失败(文件不存在)")
	} else if bytes == nil {
		return nil, errtype.NewError(errcode.BUSINESS_DATA_ERROR, err, "主机认证私钥不可用(私钥内容为空)")
	}
	masterKey := string(bytes)
	return &masterKey, nil
}
