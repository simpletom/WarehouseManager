package com.whm.models;

public class Item {
    private String name;
    private int basePrice;

    public Item(String name, int basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public String getName() {
        return this.name;
    }

    public int getBasePrice() {
        return this.basePrice;
    }
}
