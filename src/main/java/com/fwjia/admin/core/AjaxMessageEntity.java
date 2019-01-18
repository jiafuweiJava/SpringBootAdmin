package com.fwjia.admin.core;


import java.io.Serializable;

/**
 * 封装json请求返回的标准json对象
 * @author fwjia
 *
 * @param <T>
 */
public class AjaxMessageEntity<T> implements Serializable {

    /**  */
    private static final long serialVersionUID = -6666774576276552634L;

    /**
     * 返回0为成功，非0为失败
     */
    private int code = 0;

    /**
     * 默认为OK，可以自定义返回消息
     */
    private String msg = "OK";

    /**
     * 返回的数据对象
     */
    T data;


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

    public void setMessager(int code, String msg){
        this.code=code;
        this.msg=msg;
    }


}

