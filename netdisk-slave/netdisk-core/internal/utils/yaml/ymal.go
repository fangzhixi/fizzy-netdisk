package yaml

import (
	"errors"
	"fmt"
	"io/ioutil"

	"gopkg.in/yaml.v2"
)

func ReadYaml(yamlPath string, bean interface{}) error {
	bytes, err := ioutil.ReadFile(yamlPath)
	if err != nil {
		return errors.New(fmt.Errorf("yaml读取失败(文件不存在)").Error())
	}
	err = yaml.Unmarshal(bytes, bean)
	if err != nil {
		return errors.New(fmt.Errorf("yaml读取失败(yaml.Unmarshal转义失败)").Error())
	}
	return nil
}
