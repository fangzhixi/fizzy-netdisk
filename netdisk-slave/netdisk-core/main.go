package main

import (
	"crypto/hmac"
	"crypto/sha256"
	"encoding/base64"
	"fmt"
	"strings"
)

func GenHmacSha256(message string, secret string) string {
	h := hmac.New(sha256.New, []byte(secret))
	h.Write([]byte(message))
	//sha := hex.EncodeToString(h.Sum(nil))
	//fmt.Printf("sha:%s\n", sha)
	return Base64UrlSafeEncode(h.Sum(nil))
}

func Base64UrlSafeEncode(source []byte) string {
	byteArr := base64.StdEncoding.EncodeToString(source)
	safeUrl := strings.Replace(string(byteArr), "/", "_", -1)
	safeUrl = strings.Replace(safeUrl, "+", "-", -1)
	safeUrl = strings.Replace(safeUrl, "=", "", -1)
	return safeUrl
}

func main() {

	key := "adc2eb7f48928808adf27976b9e7091f"
	str := "appid=6442945423160112576"
	ret := GenHmacSha256(str, key)

	fmt.Printf("ret: %s\n", ret)
}
