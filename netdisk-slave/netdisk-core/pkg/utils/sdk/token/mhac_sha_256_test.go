package token_test

import (
	"fmt"
	"testing"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk/token"
)

func TestToken(t *testing.T) {
	originStr := "userID=17820478359,nonce=169081,timestamp=1620454429,masterKey=-----BEGIN MASTER KEY-----BUXIENYA/t9BvCH8H3Lp+LDvB23oPOxoarea0PX/a8+7ac2G+wCb6XJ4QPj+meSve1pZJiEqxTyRfpdPF8CpItInaA6VHf7sWyBA0seEl23pKfa21uD4c-----END MASTER KEY-----"
	fmt.Println("原始的数据:", originStr)
	data, err := token.RsaEncryptOutBase64([]byte(originStr)) //加密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Printf("经过base64转义过后的SHA-256加密:\n%s\n", *data)
	origData, err := token.RsaDecryptByBase64(*data) //解密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Println("解密后的数据:", *origData)
}

func TestTokenInvoice(t *testing.T) {
	originStr := "F1Luvm/gebE4yv1q615jFzZEuzrti0jVDXFuExFKJdwooLeJHXCjAA0mDSeor72INwGaWtZ9MdigVmR7s86flambypTE1JPvYe/uPhnT5gYxCeU99JRh96vwAIvFt6q+SJ8Sh6pExEUJkj3LPgBaawx0+yuQYiLHyAXS9LLxPZi5qZEK7DlB9sMEfKsw3s1k7HOqDkg9toldL76YbeE9/8AdIhm2dtUo482GrCOVTt6B6IEW4j00yCoA2E/8vR7bHSeRpJTiNx877wpcOqvcfm1jNF6RActM6JWPet4Key3La3PFn9j7yj+0AFKz846wHxSgeSX9rNl0W0060j9Lqw=="
	fmt.Println("原始的数据:", originStr)
	isPass, err := token.TokenInvoice(originStr)
	fmt.Println("Token身份是否通过: ", isPass, err)
}
