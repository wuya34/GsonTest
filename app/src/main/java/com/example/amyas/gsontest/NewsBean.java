package com.example.amyas.gsontest;


import java.util.List;

/**
 * author: Amyas
 * date: 2017/12/6
 */

public class NewsBean {
    private String msg;
    private int total;
    private int code;
    private List<CollectionBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "NewsBean{" +
                "msg='" + msg + '\'' +
                ", total=" + total +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public List<CollectionBean> getData() {
        return data;
    }

    public void setData(List<CollectionBean> data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}