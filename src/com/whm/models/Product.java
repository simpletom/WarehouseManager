package com.whm.models;

public class Product {
    private int ID;
    private String name;
    private int basePrice;

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getBasePrice() {
        return basePrice;
    }
}
