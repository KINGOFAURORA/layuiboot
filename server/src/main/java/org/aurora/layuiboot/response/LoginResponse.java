package org.aurora.layuiboot.response;

import java.io.Serializable;

/**
 * @author zhangjian
 * @date 2020/11/10 9:10
 */
public class LoginResponse implements Serializable {
    private Integer code;
    private String message;
    private String url;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
