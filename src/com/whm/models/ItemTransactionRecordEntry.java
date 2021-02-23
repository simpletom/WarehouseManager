package com.whm.models;

public class ItemMovementRecordEntry {
    private CustomTimestamp timeStamp;
    private String warehouseName;
    private String movementType;
    private Item item;

    public ItemMovementRecordEntry(CustomTimestamp timeStamp, String warehouseName, String movementType, Item item) {
        this.timeStamp = timeStamp;
        this.warehouseName = warehouseName;
        this.movementType = movementType;
        this.item = item;
    }

    public CustomTimestamp getTimeStamp() {
        return timeStamp;
    }

    public String getWarehouseName() {
        return this.warehouseName;
    }

    public String getMovementType() {
        return movementType;
    }

    public Item getItem() {
        return item;
    }
}
