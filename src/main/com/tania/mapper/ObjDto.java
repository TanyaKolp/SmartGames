package com.tania.mapper;

import java.util.List;

/**
 * Created by tanya on 12.12.17.
 */
public class ObjDto {
    private Long id;
    private Long itemId;
    private String name;
    private Integer number;
    private List<Long> ids;
    private List<Obj_sub_DTO> listDto;
    private Long obj_sub;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getObj_sub() {
        return obj_sub;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public void setObj_sub(Long obj_sub) {
        this.obj_sub = obj_sub;
    }

    public List<Obj_sub_DTO> getListDto() {
        return listDto;
    }

    public void setListDto(List<Obj_sub_DTO> listDto) {
        this.listDto = listDto;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Long> getIds() {
        return ids;
    }

    public void setIds(List<Long> ids) {
        this.ids = ids;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ObjDto{" +
                "itemId=" + itemId +
                ", name='" + name + '\'' +
                ", number=" + number +
                '}';
    }
}
