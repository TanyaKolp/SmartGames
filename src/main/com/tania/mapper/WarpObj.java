package com.tania.mapper;

import com.fasterxml.jackson.annotation.JsonView;

/**
 * Created by tanya on 16.02.18.
 */
public class WarpObj<T> {
    @JsonView(value = {UserView.class})
    private T obj;

    private int status;

    public WarpObj() {
    }

    public WarpObj(T obj, int status) {
        this.obj = obj;
        this.status = status;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
