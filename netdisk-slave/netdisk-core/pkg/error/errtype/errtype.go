package errtype

import (
	"errors"
	"time"
)

var (
	// ErrOrderNotAvailable returns a "record not found error". Occurs only when 当前订单失效的时候，过期或者没有可用次数
	ErrOrderNotAvailable = errors.New("order not available")

	//无此订单
	ErrOrderNotFound = errors.New("order not found")

	//业务异常
	ErrBusiExpect = errors.New("bussiness expect")

	//找不到记录
	ErrNoAvalOrder = errors.New("record not found")

	// ErrDbUpdateFail occurs when 乐观锁更新次数为0
	ErrDbUpdateNoEffect = errors.New("db update no effect")

	//ErrEntityUpdateFail  occurs when 乐观锁entity表更新次数为0
	ErrEntityUpdateFail = errors.New("entity update no effect")

	ErrNoCurrentAvailablePkg = errors.New("当前无可用资源包")

	ErrInvaildStategy = errors.New("非法的计费类型")

	ErrInnerExcept = errors.New("内部异常")
)

//错误基类
type ErrorBase struct {
	Message     string
	OriginError error
	Code        int
	Time        time.Time
}

func NewError(code int, err error, message ...string) ErrorBase {
	errBase := ErrorBase{
		Code:        code,
		OriginError: err,
		Time:        time.Now(),
	}
	if len(message) == 1 {
		errBase.Message = message[0]
	}
	return errBase
}

func (err ErrorBase) Error() string {
	return err.OriginError.Error()
}

func (err ErrorBase) ToString() string {
	time := err.Time.Format("2006年01月02日 15:04:05")
	return time + " " + err.Message + " " + err.OriginError.Error()
}

//服务器内部错误
func NewInternalServelError(logId string, code int, err error) InternalError {
	return InternalError{
		ErrorBase{
			Code:        code,
			OriginError: err,
		},
	}
}

type InternalError struct {
	ErrorBase
}

//业务参数校验错误
func NewBusinessDataError(logId string, code int, err error) BusinessDataError {
	return BusinessDataError{
		ErrorBase{
			Code:        code,
			OriginError: err,
		},
	}
}

type BusinessDataError struct {
	ErrorBase
}

//调用外部依赖错误
func NewExternalDependencyError(logId string, code int, err error) ExternalDependencyError {
	return ExternalDependencyError{
		ErrorBase{
			Code:        code,
			OriginError: err,
		},
	}
}

type ExternalDependencyError struct {
	ErrorBase
}

//外部依赖返回拒绝执行
func NewExternalDependencyRejectError(logId string, code int, err error, rawReturn interface{}) ExternalDependencyRejectError {
	return ExternalDependencyRejectError{
		ErrorBase: ErrorBase{
			Code:        code,
			OriginError: err,
		},
		RawReturn: rawReturn,
	}
}

type ExternalDependencyRejectError struct {
	ErrorBase
	RawReturn interface{}
}

//参数检验错误
func NewValidateError(logId string, error error) ValidateError {
	return ValidateError{
		LogId:       logId,
		OriginError: error,
	}
}

type ValidateError struct {
	LogId       string
	OriginError error
}
