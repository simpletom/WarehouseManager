package com.whm.models;

public class ItemMovement {
    private CustomTimeStamp timeStamp;
    private String movementType;
    private Item item;

    public ItemMovement(CustomTimeStamp timeStamp, String movementType, Item item) {
        this.timeStamp = timeStamp;
        this.movementType = movementType;
        this.item = item;
    }

    public CustomTimeStamp getTimeStamp() {
        return timeStamp;
    }

    public String getMovementType() {
        return movementType;
    }

    public Item getItem() {
        return item;
    }
}
