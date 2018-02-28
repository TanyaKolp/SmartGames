package com.tania.model_mapper;


/**
 * Created by tanya on 05.02.18.
 */
public class Dto {
    private Integer id;
    private Integer itemId;
    private String desc;

    public Dto() {
    }

    public Dto(Integer id, Integer itemId, String desc) {
        this.id = id;
        this.itemId = itemId;
        this.desc = desc;
    }

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
