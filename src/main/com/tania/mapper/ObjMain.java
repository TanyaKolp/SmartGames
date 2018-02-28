package com.tania.mapper;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.List;

/**
 * Created by tanya on 12.12.17.
 */
public class ObjMain {
    private Long id;
    @JsonView(value = {UserView.class})
    private Long itemId;
    private String name;
    @JsonView(value = Update.class)
    private Integer number;
    private List<Obj_sub> obj_subs;
    private List<Obj_sub> list;
    private Obj_sub obj_sub;

    public Long getId() {
        return id;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Obj_sub getObj_sub() {
        return obj_sub;
    }

    public void setObj_sub(Obj_sub obj_sub) {
        this.obj_sub = obj_sub;
    }

    public List<Obj_sub> getList() {
        return list;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setList(List<Obj_sub> list) {
        this.list = list;
    }

    public List<Obj_sub> getObj_subs() {
        return obj_subs;
    }

    public void setObj_subs(List<Obj_sub> obj_subs) {
        this.obj_subs = obj_subs;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjMain{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", obj_subs=" + obj_subs +
                ", list=" + list +
                '}';
    }
}
