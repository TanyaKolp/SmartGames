package com.tania.model_mapper;

import java.math.BigDecimal;

/**
 * Created by tanya on 05.02.18.
 */
public class Base {
    private Integer id;
    private String desc;

    private BigDecimal numb;


    @Override
    public String toString() {
        return "Base{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }

    public BigDecimal getNumb() {
        return numb;
    }

    public void setNumb(BigDecimal numb) {
        this.numb = numb;
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
