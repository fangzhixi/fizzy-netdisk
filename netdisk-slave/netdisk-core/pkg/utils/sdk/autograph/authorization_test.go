package autograph_test

import (
	"fmt"
	"testing"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/sdk/autograph"
)

func TestAuthorization(t *testing.T) {
	originStr := "algorithm=HMAC-SHA256,address=http://192.168.0.1,nonce=398888,timestamp=1620454429master_key=-BEGIN MASTER KEY-X3gTwDsH0e0CeGH6DQ099UT3XJLL/zewIDAQABAoIBf1ZwF23mGcvfvNKM9dltM5BpxvaPGUWOpBqLln75NJVuTJKMD4Lh63mP2tWEmMTVezEowawEt1jK-END MASTER KEY-"
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

func TestMasterInvoice(t *testing.T) {
	originStr := "xx9ofSfZSkQSESydAS0fiYwSMD3CoJgWERaN9ym8TY5is52e/fZET+3zXymJXBG6xDvnDO2n9H6/IoEXp0YxmVWONk1LKj8m9l97DjY1vemwg9LrgH6DbPseSDbri2CuaPchv/RTUXsHbrLKOuLEN89I1cwaV+fIa+JOH8VKIhRq2H8oAQvitic9k4ulOCbYojjxDo4kUdQuvkqJ4Z0SRc2yeGlrPo/APCJwgqZ10XGlPJ4nsWtp8N6dVFrmXQ2y9O5R3ukBLsCHnQYQ8oNGNiVhknOrRsTz99R3/EUQ5o9yLTsPschfphTBk/TUeFqvXAi5A5NTObf05UszhlCnbA=="
	fmt.Println("原始的数据:", originStr)

	master := autograph.Master{}
	fmt.Println("验证前Token: ", master)
	isPass, err := master.MasterInvoice(&originStr)
	fmt.Println("Token身份是否通过: ", isPass, err)
	fmt.Println("验证后Token: ", master.Nonce)
}
