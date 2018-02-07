package com.tania.mapper;

/**
 * Created by tanya on 05.02.18.
 */
public class Base {
    private Integer id;
    private String desc;


    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
