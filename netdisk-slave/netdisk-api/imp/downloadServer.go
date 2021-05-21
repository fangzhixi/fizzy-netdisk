package imp

import (
	"fmt"
	"io"
	"net/http"
	"os"
	"strconv"
)

func DownloadHandler(w http.ResponseWriter, r *http.Request) {
	filename := "./newFile"

	file, err := os.Open(filename)
	if err != nil {
		fmt.Println(err)
		panic(err)
	}
	defer file.Close()

	fileHeader := make([]byte, 512)
	file.Read(fileHeader)

	fileStat, _ := file.Stat()

	w.Header().Set("Content-Disposition", "attachment; filename="+filename)
	w.Header().Set("Content-Type", http.DetectContentType(fileHeader))
	w.Header().Set("Content-Length", strconv.FormatInt(fileStat.Size(), 10))

	file.Seek(0, 0)
	io.Copy(w, file)
}
