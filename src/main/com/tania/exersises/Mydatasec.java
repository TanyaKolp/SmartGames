package com.tania.exersises;

/**
 * Created by tanya on 02.08.17.
 */
public class Mydatasec {
    private String name;
    private int id;
    private String birthDate;

    public Mydatasec(String name, int id, String birthDate) {
        this.name = name;
        this.id = id;
        this.birthDate = birthDate;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
}
