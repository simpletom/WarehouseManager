package com.whm.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private String name;
    private Map<String, Integer> storage;
    private List<ItemTransactionRecordEntry> transactionRecord;

    public Warehouse(String name) {
        this.name = name;
        this.storage = new HashMap<>();
        this.transactionRecord = new ArrayList<>();
    }

    public void addItems(CustomTimestamp timestamp, String itemName, int itemQuantity) {
        if(this.storage.containsKey(itemName)) {
            // Item in found in storage, update quantity
            Integer newQuantity = this.storage.get(itemName) + itemQuantity;
            this.storage.put(itemName, newQuantity);
        } else {
            // Item is not in storage, create entry
            this.storage.put(itemName, itemQuantity);
        }

        this.transactionRecord.add(new ItemTransactionRecordEntry(timestamp, itemQuantity, itemName, "IN"));
    }

    public void removeItems(CustomTimestamp timestamp, String itemName, int itemQuantity) {
        if(this.storage.containsKey(itemName)) {
            Integer newQuantity = this.storage.get(itemName) - itemQuantity;
            if(newQuantity < 1) {
                this.storage.remove(itemName);
            } else {
                this.storage.put(itemName, newQuantity);
            }
        }

        this.transactionRecord.add(new ItemTransactionRecordEntry(timestamp, itemQuantity, itemName, "OUT"));
    }

    public String getName() {
        return this.name;
    }

    public WarehouseTransactionRecord getTransactionRecord() {
        return new WarehouseTransactionRecord(this.name, this.transactionRecord);
    }
}
