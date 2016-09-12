package com.pyn.rtexchagerate.Bean;

/**
 * 返回结果
 */
public class BaseCallResultBean {

    private String reason;      // 返回说明
    private String result;      // 返回结果集
    private String error_code;  // 返回码

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }
}