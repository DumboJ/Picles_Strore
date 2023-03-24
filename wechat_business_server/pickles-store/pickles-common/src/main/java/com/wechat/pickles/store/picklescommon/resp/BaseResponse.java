package com.wechat.pickles.store.picklescommon.resp;

/**
 * 接口统一返回格式
 * */
public class BaseResponse {
    private int errorCode;
    private String msg;
    private Object data;

    public BaseResponse(ResponseCode responseCode) {
        this.errorCode = responseCode.getCode();
        this.msg = responseCode.getDesc();
    }
    public BaseResponse(ResponseCode responseCode,Object data) {
        this.errorCode = responseCode.getCode();
        this.msg = responseCode.getDesc();
        this.data = data;
    }

    public BaseResponse(int errorCode, String msg) {
        this.errorCode = errorCode;
        this.msg = msg;
    }

    public BaseResponse(int errorCode, String msg, Object data) {
        this.errorCode = errorCode;
        this.msg = msg;
        this.data = data;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
