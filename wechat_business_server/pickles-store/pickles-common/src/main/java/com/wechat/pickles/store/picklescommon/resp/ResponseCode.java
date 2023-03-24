package com.wechat.pickles.store.picklescommon.resp;
/**
 * 结果编码
 * */
public enum ResponseCode {
    SUCCESSS(0,"成功"),
    SUCCESS_NULL(0,"查询结果为空"),
    PARAM_ERR(1001,"参数错误"),
    NET_ERR(1002,"网络错误"),
    PERMISSION_ERR(1003,"无权访问"),
    INNER_ERR(1009,"API系统内部错误"),
    INVALID_ERR(1500,"目标服务不可用"),
    TIMEOUT_ERR(1504,"目标接口超时"),
    MISS_ERR(1404,"找不到目标服务"),
    ;
    private int code;
    private String desc;

    ResponseCode(int respCode, String desc) {
        this.code = respCode;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
