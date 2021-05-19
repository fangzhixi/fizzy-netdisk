package sdk

import (
	"bytes"
	"errors"
	"fmt"
	"io/ioutil"
	"net"
	"net/http"
)

type Sdk struct {
	BaseUrl string //IP地址、域名
}

func (s *Sdk) HttpPost(url string, headers map[string]string, postData []byte) ([]byte, error) {
	if postData != nil {
		fmt.Println("accounting-archive 请求地址：", s.BaseUrl+url, "请求参数：", string(postData))
	} else {
		fmt.Println("accounting-archive 请求地址：", url)
	}

	client := &http.Client{}
	request, err := http.NewRequest("POST", s.BaseUrl+url, bytes.NewBuffer(postData))
	if err != nil {
		return nil, err
	}

	for h, v := range headers {
		request.Header.Add(h, v)
	}

	fmt.Println("request: ", request)
	r, err := client.Do(request)
	if err != nil {
		return nil, err
	}
	defer r.Body.Close()

	body, err := ioutil.ReadAll(r.Body)
	if r.StatusCode > 499 {
		err = fmt.Errorf("状态：%v，结构体:%v", r.Status, string(body))
	}

	fmt.Println("地址：", url, " 请求结果：", string(body))
	return body, err
}

//获取本机真实IP
func ExternalIP() (net.IP, error) {
	ifaces, err := net.Interfaces()
	if err != nil {
		return nil, err
	}
	for _, iface := range ifaces {
		if iface.Flags&net.FlagUp == 0 {
			continue // interface down
		}
		if iface.Flags&net.FlagLoopback != 0 {
			continue // loopback interface
		}
		addrs, err := iface.Addrs()
		if err != nil {
			return nil, err
		}
		for _, addr := range addrs {
			ip := getIpFromAddr(addr)
			if ip == nil {
				continue
			}
			return ip, nil
		}
	}
	return nil, errors.New("connected to the network?")
}

func getIpFromAddr(addr net.Addr) net.IP {
	var ip net.IP
	switch v := addr.(type) {
	case *net.IPNet:
		ip = v.IP
	case *net.IPAddr:
		ip = v.IP
	}
	if ip == nil || ip.IsLoopback() {
		return nil
	}
	ip = ip.To4()
	if ip == nil {
		return nil // not an ipv4 address
	}

	return ip
}
