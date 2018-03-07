package com.piaoling.controller;


/**
 * Dubbo 返回结果
 * Created by lyf
 * on 2015/11/5.
 */
public class ActionResult<T>  {
    private int code;
    private String message;
    private T data;
    public static <T> ActionResult<T> New(T data)
    {
        ActionResult<T> ret = new ActionResult<T>();
        ret.setData(data);
        ret.setCode(0);
        return ret;
    }
    public static <T> ActionResult<T> New(int code,String message)
    {
        ActionResult<T> ret = new ActionResult<T>();
        ret.setCode(code);
        ret.setMessage(message);
        return ret;
    }
    public void set(int code, String message){
        this.code = code;
        this.message = message;
    }
    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
