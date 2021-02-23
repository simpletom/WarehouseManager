package com.whm.models;

public class ItemTransactionRecordEntry {
    private String itemName;
    private String transactionType;
    private CustomTimestamp timestamp;
    private int quantity;

    public ItemTransactionRecordEntry(CustomTimestamp timestamp, int quantity, String itemName, String transactionType) {
        this.timestamp = timestamp;
        this.itemName = itemName;
        this.transactionType = transactionType;
        this.quantity = quantity;
    }

    public String getEntryAsCSV() {
        return this.timestamp.getTimestampAsCSV() + ","
                + this.itemName + ","
                + this.quantity + ","
                + this.transactionType;
    }
}
