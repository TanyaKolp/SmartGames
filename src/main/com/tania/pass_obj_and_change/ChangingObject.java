package com.tania.pass_obj_and_change;

/**
 * Created by tanya on 15.12.17.
 */
public class ChangingObject {
    private String string;
    private Integer number;

    @Override
    public String toString() {
        return "ChangingObject{" +
                "string='" + string + '\'' +
                ", number=" + number +
                '}';
    }

    public ChangingObject() {
    }

    public ChangingObject(String string, Integer number) {
        this.string = string;
        this.number = number;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
