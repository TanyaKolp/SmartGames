package com.tania.mapper;

/**
 * Created by tanya on 12.12.17.
 */
public class
Obj_sub_DTO {
    private String name;
    private Long id;

    public Obj_sub_DTO() {
    }

    @Override
    public String toString() {
        return "Obj_sub_DTO{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    public Obj_sub_DTO(String name, Long id) {
        this.name = name;
        this.id = id;
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
