package com.tania.mapper;

/**
 * Created by tanya on 12.12.17.
 */
public class Obj_sub {
    private String name;
    private Long id;
    private String s;

    public Obj_sub() {
    }

    public Obj_sub(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Obj_sub{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", s='" + s + '\'' +
                '}';
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
