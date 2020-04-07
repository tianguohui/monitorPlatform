package com.ph.monitorPlatform.utils;

/**
 * 描述: json格式数据返回码
 * <ul>
 * <li>100 : 用户未登录 </li>
 * <li>200 : 成功 </li>
 * <li>300 : 失败 </li>
 * </ul>
 *
 * @author : Administrator
 */
public enum JsonReturnCode {

    SUCCESS(200, "OK"),
    NOT_LOGIN(401, "Unauthorized"),
    ACCESS_ERROR(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    FAIL(500, "Internal Server Error"),

    INVALID_CLIENTID(1001, "Invalid ClientId"),
    INVALID_PASSWORD(1002, "Invalid Password"),
    INVALID_TOKEN(1003, "Invalid Token"),
    PERMISSION_DENIED(1004, "Permission Denied");

    private int code;
    private String desc;

    JsonReturnCode(int code, String desc) {
        this.code = code;
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
