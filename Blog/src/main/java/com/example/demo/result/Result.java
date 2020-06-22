package com.example.demo.result;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/6 15:02
 */
public class Result {
    private int code;
    private String message;
    private Object data;

    Result(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data= data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
