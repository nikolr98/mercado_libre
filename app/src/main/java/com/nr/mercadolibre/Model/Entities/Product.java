package com.nr.mercadolibre.Model.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class Product implements Serializable {
    private String title;
    private int price;
    private  int available_quantity;
    private ArrayList<AtributosProduct> attributes;
    private  String thumbnail;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAvailable_quantity() {
        return available_quantity;
    }

    public void setAvailable_quantity(int available_quantity) {
        this.available_quantity = available_quantity;
    }

    public ArrayList<AtributosProduct> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<AtributosProduct> attributes) {
        this.attributes = attributes;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
