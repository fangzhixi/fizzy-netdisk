package iodisk

import (
	"log"
	"os"
)

// 判断文件是否存在
func IsExist(fileAddr string) bool {
	// 读取文件信息，判断文件是否存在
	_, err := os.Stat(fileAddr)
	if err != nil {
		log.Println(err)
		if os.IsExist(err) { // 根据错误类型进行判断
			return true
		}
		return false
	}
	return true
}
