package com.whm.models;

public class Item {
    private String name;
    private int basePrice;
    private int quantity;

    public Item(String name, int basePrice, int quantity) {
        this.name = name;
        this.basePrice = basePrice;
        this.quantity = quantity;

    }
    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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
