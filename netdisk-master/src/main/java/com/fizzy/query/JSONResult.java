package com.fizzy.query;

public class JSONResult {
    private boolean success;
    private String msg;

    public JSONResult() {
        success = false;
        msg = "";
    }

    public JSONResult success(String msg)
    {
        this.msg = msg;
        this.success = true;
        return this;
    }

    public JSONResult noSuccess(String msg)
    {
        this.msg = msg;
        this.success = false;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "JSONResponse{" +
                "success=" + success +
                ", msg='" + msg + '\'' +
                '}';
    }
}
