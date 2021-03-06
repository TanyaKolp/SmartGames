package com.tania.entity;

/**
 * Created by tanya on 04.09.17.
 */
public class Data {
    String key;
    String value;

    public Data(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "key " + key + ", value " + value;
    }
}
