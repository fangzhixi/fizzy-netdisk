package errcode

type Code int

const (
	OK                  = 0
	UNDERFINE           = 900
	BUSINESS_DATA_ERROR = 1014

	BAD_REQUEST                = 400
	FORBIDDEN                  = 403
	INTERNAL_SERVER_ERROR      = 500
	VALIDATE_ERROR             = 1010
	EXTERNAL_DEPENDENCY_ERROR  = 1016
	EXTERNAL_DEPENDENCY_REJECT = 1017

	No_AVAILABLE_PKG_ERROR = 5001
)

const (
	Ok                = 0
	Undefine          = 900
	BusinessDataError = 1014

	BadRequest               Code = 400
	Forbidden                Code = 403
	InternalServerError      Code = 500
	ValidateError            Code = 1010
	ExternalDependencyError  Code = 1016
	ExternalDependencyReject Code = 1017

	NoAvailablePkgError Code = 5001
)

var ErrorMsg = map[Code]string{
	Ok:                "返回成功",
	Undefine:          "未定义",
	BusinessDataError: "业务逻辑错误 {ERRMSG}",

	BadRequest:              "错误的请求",
	Forbidden:               "表示资源不可用",
	InternalServerError:     "服务器服务错误",
	ExternalDependencyError: "依赖其他项目错误 {ERRMSG}",
	ValidateError:           "参数验证错误 {ERRMSG}",
}
