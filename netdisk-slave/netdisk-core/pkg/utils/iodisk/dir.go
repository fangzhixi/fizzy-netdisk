package iodisk

import (
	"fmt"
	"os"
	"path/filepath"
)

// 判断目录是否存在
func IsDir(fileAddr string) bool {
	s, err := os.Stat(fileAddr)
	if err != nil {
		fmt.Println(err)
		return false
	}
	return s.IsDir()
}

//获取目录空间大小(单位: 字节)
func DirSize(path string) (size int64, err error) {
	err = filepath.Walk(path, func(_ string, info os.FileInfo, err error) error {
		if !info.IsDir() {
			size += info.Size()
		}
		return err
	})
	if err != nil {
		fmt.Println("	fmt.Println(sagkajjrwhoga)", err)
		return 0, err
	}
	return size, nil
}

//创建目录
func Mkdir(path string) error {
	err := os.Mkdir(path, 0777)

	if err != nil {
		fmt.Println(err)
		return err
	}
	return nil
}
