package cros

import "net/http"

func ResponseWithOrigin(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Access-Control-Allow-Headers", "Content-Type,Access-Token,Appid,Secret,Authorization,content-type,filename,element-id,token")
	w.Header().Set("Access-Control-Allow-Origin", "*")
	w.Header().Set("Content-Type", "application/json; charset=utf-8")
}
