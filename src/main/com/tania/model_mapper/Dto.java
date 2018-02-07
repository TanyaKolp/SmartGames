package com.tania.model_mapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by tanya on 05.02.18.
 */
@JsonIgnoreProperties({"id"})
public class Dto {
    //    @JsonDeserialize(converter = )
    private Integer id;
    private Integer itemId;
    private String desc;

    @Override
    public String toString() {
        return "Dto{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", desc='" + desc + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
