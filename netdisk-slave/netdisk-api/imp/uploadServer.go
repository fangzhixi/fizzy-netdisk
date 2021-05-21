package imp

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"net/url"
	"os"

	"github.com/fangzhixi/fizzy-netdisk/netdisk-slave/netdisk-core/pkg/utils/cros"
)

func UploadHandler(w http.ResponseWriter, r *http.Request) {
	for key, value := range r.Header {
		fmt.Println("key: ", key)
		fmt.Println("value: ", value)
	}
	filename, err := url.QueryUnescape(fmt.Sprintf("%s", r.Header["Filename"]))
	if err != nil {
		fmt.Println(err)
		panic(err)
	}
	// element_id, err := url.QueryUnescape(fmt.Sprintf("%s", r.Header["element_id"]))
	// if err != nil {
	// 	fmt.Println(err)
	// 	panic(err)
	// }
	// token, err := url.QueryUnescape(fmt.Sprintf("%s", r.Header["token"]))
	// if err != nil {
	// 	fmt.Println(err)
	// 	panic(err)
	// }
	//去掉header文件名中括号(例: [example.exe])
	if len := len(filename); len > 2 {
		fmt.Println(len)
		filename = filename[1 : len-1]
	}

	fmt.Println("解码后文件名:", filename)

	file, err := os.Create(filename)
	if err != nil {
		fmt.Println(err)
		panic(err)
	}

	data, _ := ioutil.ReadAll(r.Body)
	// fmt.Println(data)
	ioutil.WriteFile(file.Name(), data, 0777)
	_, err = io.Copy(file, r.Body)
	if err != nil {
		fmt.Println(err)
		panic(err)
	}
	if err := file.Close(); err != nil {
		fmt.Println(err)
		panic(err)
	}
	cros.ResponseWithOrigin(w, r)
	w.Write([]byte("upload success"))
}
