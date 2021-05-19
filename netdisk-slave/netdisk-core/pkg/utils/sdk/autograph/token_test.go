package autograph_test

import (
	"fmt"
	"testing"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk/autograph"
)

func TestToken(t *testing.T) {
	originStr := "algorithm=HMAC-SHA256,user_id=gd_abcdefghijklmn,nonce=398888,timestamp=1590719810,master_key=-BEGIN MASTER KEY-X3gTwDsH0e0CeGH6DQ099UT3XJLL/zewIDAQABAoIBf1ZwF23mGcvfvNKM9dltM5BpxvaPGUWOpBqLln75NJVuTJKMD4Lh63mP2tWEmMTVezEowawEt1jK-END MASTER KEY-"
	fmt.Println("原始的数据:", originStr)
	data, err := autograph.RsaEncryptOutBase64(&originStr) //加密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Printf("经过base64转义过后的SHA-256加密:\n%s\n", *data)
	origData, err := autograph.RsaDecryptByBase64(data) //解密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Println("解密后的数据:", *origData)
}

func TestTokenInvoice(t *testing.T) {
	originStr := "k9AXilWsh8dyllo9LXoynYbmpRfyIZeawlbsP7k50W3p6wT59IWP+6cUGMGW5SLX2+06INTqtfajRFhYVb/pYfLNHRHBWvktsmHjeQH6/Md3ZZk5LmnNDJSEVSGAOP0qfHJ9hbwzddbE/l+9dVUKwo2ddPrWcLaQbmmXN3BasYBGahpWbJML5FeBrJ/pCdvmd5YOTzpua9XTb75pjAOv1dV4wdT01qxMY1TQRLwUW5qVKHeNC6t37BwkGKR3Asxs0LqpDZaQBwYOhcOz9+AU7MjLi/H5jPmvf3Kek0N4DRYx/DH9uzdHL8ZMjhHPgSNQTIt90OZK750rxrTse4CiXQ=="
	fmt.Println("原始的数据:", originStr)

	token := autograph.Token{}
	fmt.Println("验证前Token: ", token)
	isPass, err := token.TokenInvoice(&originStr)
	fmt.Println("Token身份是否通过: ", isPass, err)
	fmt.Println("验证后Token: ", token)
}
