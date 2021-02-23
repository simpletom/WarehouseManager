package com.whm.models;

/**
 *  The ItemTransActionRecordEntry holds information regarding what item in which quantity was moved in or out of a
 *  specified warehouse.
 */

public class ItemTransactionRecordEntry implements Comparable<ItemTransactionRecordEntry> {
    private final CustomTimestamp timestamp;
    private final String itemName;
    private final String warehouseName;
    private final String transactionType;
    private final int quantity;

    public ItemTransactionRecordEntry(CustomTimestamp timestamp, String itemName, String warehouseName, int quantity, String transactionType) {
        this.timestamp = timestamp;
        this.itemName = itemName;
        this.warehouseName = warehouseName;
        this.transactionType = transactionType;
        this.quantity = quantity;
    }

    public String getEntryAsCSV() {
        return this.timestamp.getTimestampAsCSV() + ","
                + this.itemName + ","
                + this.quantity + ","
                + this.warehouseName + ","
                + this.transactionType;
    }

    @Override
    public int compareTo(ItemTransactionRecordEntry itemRecordEntry) {
        if(this == itemRecordEntry) {
            return 0;
        }

        return this.timestamp.compareTo(itemRecordEntry.timestamp);
    }
}
