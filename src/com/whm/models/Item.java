package com.whm.models;

public class Item {
    private String name;
    private int basePrice;
    private String unitType;

    public Item(String name, int basePrice, String unitType) {
        this.name = name;
        this.basePrice = basePrice;
        this.unitType = unitType;
    }

    public String getName() {
        return this.name;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public String getUnitType() { return this.unitType; }
}
