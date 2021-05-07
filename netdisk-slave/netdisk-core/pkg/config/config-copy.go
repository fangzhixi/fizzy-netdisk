package config

import (
	"flag"
	"time"
)

type MongoDB struct {
	Uri   string `yaml:"uri"`
	Debug bool   `yaml:"debug"`
}

type Configuration1 struct {
	Env           string `yaml:"env"`
	AppName       string `yaml:"app_name"`
	LogPath       string `yaml:"log_path"`
	LogLevel      uint32 `yaml:"log_level"`
	ListenAddress int    `yaml:"listen_address"`

	SentryDsn string `yaml:"sentry_dsn"`

	// RabbitMq struct {
	// 	URL          string `yaml:"url"`
	// 	ExchangeName string `yaml:"exchange_name"`
	// } `yaml:"rabbit_mq"`

	MongoDB map[string]MongoDB `yaml:"mongo_db"`

	AppCenterURL     string `yaml:"app_center_url"`
	BillingCenterURL string `yaml:"billing_center_url"`
	UniqueIDURL      string `yaml:"unique_id_url"`
	JaegerAgentUri   string `yaml:"jaeger_agent_uri"`
	UserCenter       string `yaml:"user_center"`

	RConfig RemoteConf `yaml:"remote_conf"` //远端配置

}

//RemoteConf nacos服务器配置
type RemoteConf struct {
	LogLevel       uint32 `yaml:"log_level"`
	LogPath        string `yaml:"log_path"`
	Mode           string `yaml:"mode"`
	DbLogEnable    bool   `yaml:"db_log_enable"`
	GinHost        string `yaml:"gin_host"`
	SentryDsn      string `yaml:"sentry_dsn"`
	JaegerAgentUri string `yaml:"jaeger_agent_uri"`
	SM4_key        string `yaml:"sm4_key"`

	Db map[string]struct {
		Driver      string        `yaml:"driver"`
		Uri         string        `yaml:"uri"`
		Username    string        `yaml:"user_name"`
		Password    string        `yaml:"password"`
		MaxOpenConn int           `yaml:"max_open_conn"`
		MaxIdleConn int           `yaml:"max_idle_conn"`
		MaxLifetime time.Duration `yaml:"max_life_time"`
	} `yaml:"db"`

	TicketOcrUrl     string `yaml:"ticket_ocr_url"`    //发票OCR
	PlatformRegistry string `yaml:"platform_registry"` //tars
	UniqueIdUrl      string `yaml:"uniqueid_url"`      //生成唯一ID

	GoldenCloud struct {
		AppKey    string `yaml:"app_key"`
		AppSecret string `yaml:"app_secret"`
		ApiAddr   string `yaml:"api_addr"`
	} `yaml:"golden_cloud"`

	Cos struct {
		CosSecretId        string `yaml:"cos_secret_id"`
		CosSecretKey       string `yaml:"cos_secret_key"`
		CosSecretBucketUrl string `yaml:"cos_secret_bucketurl"`
		CosSecretBucket    string `yaml:"cos_secret_bucket"`
		CosSecretAppId     string `yaml:"cos_secret_app_id"`
		CosSecretArea      string `yaml:"cos_secret_area"`
	} `yaml:"cos"`
	TaxpayerNo string `yaml:"taxpayer_no"`

	Redis struct {
		Uri      string `yaml:"uri"`
		Password string `yaml:"password"`
		Db       int    `yaml:"db"`
	} `yaml:"redis"`

	Cas struct {
		AppId         int    `yaml:"app_id"`
		AppSecret     string `yaml:"app_secret"`
		ApiAddr       string `yaml:"api_addr"`
		ApiUidToken   string `yaml:"api_uid_token"`
		ApiGetUser    string `yaml:"api_get_user"`
		ApiCheckToken string `yaml:"api_check_token"`
		ApiRegister   string `yaml:"api_register"`
	} `yaml:"cas"`
	DcacheRegistry string `yaml:"dcache_registry"`
}

func init() {
	// flag.StringVar(&configFilePath, "conf", "./config/conf.yaml", "config name")
	flag.Parse()
	// fmt.Println("[INFO] reading config path:", configFilePath)
}
