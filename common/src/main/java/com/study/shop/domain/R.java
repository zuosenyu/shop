package com.study.shop.domain;

import java.io.Serializable;

/**
 * @author: zuosy
 * @date 2021/11/11 10:28
 */
public class R<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 成功
     */
    public static final int SUCCESS = 200;

    /**
     * 失败
     */
    public static final int FAIL = 500;

    /**
     * 返回状态，是否成功
     */
    private boolean status;

    /**
     * 返回状态码
     */
    private int code;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 返回对象数据
     */
    private T data;

    public static <T> R<T> ok() {
        return restResult(true,null, SUCCESS, null);
    }

    public static <T> R<T> ok(T data) {
        return restResult(true,data, SUCCESS, null);
    }

    public static <T> R<T> ok(T data, String msg) {
        return restResult(true,data, SUCCESS, msg);
    }

    public static <T> R<T> fail() {
        return restResult(false,null, FAIL, null);
    }

    public static <T> R<T> fail(String msg) {
        return restResult(false,null, FAIL, msg);
    }

    public static <T> R<T> fail(T data) {
        return restResult(false,data, FAIL, null);
    }

    public static <T> R<T> fail(T data, String msg) {
        return restResult(false,data, FAIL, msg);
    }

    public static <T> R<T> fail(int code, String msg) {
        return restResult(false,null, code, msg);
    }

    private static <T> R<T> restResult(boolean status,T data, int code, String msg) {
        R<T> apiResult = new R<>();
        apiResult.setStatus(status);
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
