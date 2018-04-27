package com.tania.entity;

/**
 * Created by tanya on 12.10.17.
 */
public class Item implements Comparable{
    String name;
    Double price;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public Item(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.name, this.price);
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
