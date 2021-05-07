package model

import "time"

type WarningMsg struct {
	Id          int
	OrderId     int64     `gorm:"column:order_id"`
	UserId      int       `gorm:"column:user_id"`
	ProductType string    `gorm:"column:product_type"`
	WarnType    int       `gorm:"column:warn_type"`
	NotifyType  int       `gorm:"column:notify_type"`
	NotifyState int       `gorm:"column:notify_state"`
	Email       string    `gorm:"column:email"`
	Phone       string    `gorm:"column:phone"`
	IsRead      int       `gorm:"column:is_read"`
	IsDel       int       `gorm:"column:is_del"`
	WarnContext string    `gorm:"column:warn_context"`
	Title       string    `gorm:"column:title"`
	DeviceNo    string    `gorm:"column:device_no"`
	ServiceType int       `gorm:"column:service_type"`
	KeyOne      int       `gorm:"column:key_one"`
	FailMsg     string    `gorm:"column:fail_msg"`
	CreatedAt   time.Time `gorm:"column:created_at"`
	UpdatedAt   time.Time `gorm:"column:updated_at"`
	TaxCode     string    `gorm:"column:tax_code"`
	DevNum      string    `gorm:"column:dev_num"`
}

func (WarningMsg) TableName() string {
	return "w_warning_msg"
}
