package errcode

type Code int

const (
	Ok                Code = 0
	Undefine          Code = 900
	BusinessDataError Code = 1014

	BadRequest               Code = 400
	Forbidden                Code = 403
	InternalServerError      Code = 500
	ValidateError            Code = 1010
	ExternalDependencyError  Code = 1016
	ExternalDependencyReject Code = 1017

	NoAvailablePkgError Code = 5001
)

var ErrorMsg = map[Code]string{
	Ok:                "success",
	BusinessDataError: "业务逻辑错误 {ERRMSG}",

	BadRequest:              "Bad Request",
	Forbidden:               "Forbidden",
	InternalServerError:     "Server Internal Error",
	ExternalDependencyError: "依赖其他项目错误 {ERRMSG}",
	ValidateError:           "参数验证错误 {ERRMSG}",
}
