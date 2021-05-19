package service

import (
	"fmt"
	"io"
	"io/ioutil"
	"net/http"
	"os"
)

func UploadHandler(w http.ResponseWriter, r *http.Request) {
	file, err := os.Create("./newFile")
	if err != nil {
		fmt.Println(err)
		panic(err)
	}

	data, _ := ioutil.ReadAll(r.Body)
	fmt.Println(data)
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
	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Write([]byte("upload success"))

}

func ResponseWithOrigin(w http.ResponseWriter, r *http.Request, code int, json []byte) {
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.WriteHeader(code)
	w.Write(json)
}
