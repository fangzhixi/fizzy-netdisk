package token_test

import (
	"fmt"
	"testing"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk/token"
)

func TestToken(t *testing.T) {
	originStr := "algorithm=HMAC-SHA256,userID=gd_abcdefghijklmn,nonce=398888,timestamp=1590719810,masterKey=-BEGIN MASTER KEY-X3gTwDsH0e0CeGH6DQ099UT3XJLL/zewIDAQABAoIBf1ZwF23mGcvfvNKM9dltM5BpxvaPGUWOpBqLln75NJVuTJKMD4Lh63mP2tWEmMTVezEowawEt1jK-END MASTER KEY-"
	fmt.Println("原始的数据:", originStr)
	data, err := token.RsaEncryptOutBase64(&originStr) //加密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Printf("经过base64转义过后的SHA-256加密:\n%s\n", *data)
	origData, err := token.RsaDecryptByBase64(data) //解密
	if err != nil {
		fmt.Println(err.Error())
	}
	fmt.Println("解密后的数据:", *origData)
}

func TestTokenInvoice(t *testing.T) {
	originStr := "DWosD6K3J/Qtl8rQfjTZN4dLGmRyqT4LrWc0xKglGpdsM/sBeyaqUsL2/bL/JHk7WlRwOnlR9IAynYcVJcVbE0APJfWHl6NkwfUjIuXTMNjZSsSELEUR+/LNFBHuyvhT2CyftutaQz254q2MPpCP/f6Wlsc8W98iHJaftIBl48bqFqMvYBgN7Heu/zTtrIqSXxheXVI2kI8XHfbV86GanILpkN53gY2Vxb1pfabQ6wOiKl6ojVQ1wnSIxjHuOcBNPXkMeY2YttSzIFtbdOem+CGbB57VYvIzi7usIQoTDF4PLgJAm6exaNENyOyfPerMPoGwiqACVNpZRMQbVTVpqA=="
	fmt.Println("原始的数据:", originStr)
	isPass, err := token.TokenInvoice(&originStr)
	fmt.Println("Token身份是否通过: ", isPass, err)
}
