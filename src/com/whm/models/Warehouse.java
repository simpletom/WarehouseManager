package com.whm.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Warehouse {
    private String name;
    private Map<String, Integer> inventory;
    private List<ItemTransactionRecordEntry> transactionRecord;

    public Warehouse(String name) {
        this.name = name;
        this.inventory = new HashMap<>();
        this.transactionRecord = new ArrayList<>();
    }

    public void addItems(CustomTimestamp timestamp, String itemName, int itemQuantity) {
        if(this.inventory.containsKey(itemName)) {
            // Item in found in storage, update quantity
            Integer newQuantity = this.inventory.get(itemName) + itemQuantity;
            this.inventory.put(itemName, newQuantity);
        } else {
            // Item is not in storage, create entry
            this.inventory.put(itemName, itemQuantity);
        }

        // If items are added to the inventory, the transaction type "IN" denotes it
        this.transactionRecord.add(new ItemTransactionRecordEntry(timestamp, itemName, this.name, itemQuantity, "IN"));
    }

    public void removeItems(CustomTimestamp timestamp, String itemName, int itemQuantity) {
        if(this.inventory.containsKey(itemName)) {
            Integer newQuantity = this.inventory.get(itemName) - itemQuantity;
            if(newQuantity < 1) {
                this.inventory.remove(itemName);
            } else {
                this.inventory.put(itemName, newQuantity);
            }
        }

        // If items are removed from the inventory, the transaction type "OUT" denotes it
        this.transactionRecord.add(new ItemTransactionRecordEntry(timestamp, itemName, this.name, itemQuantity, "OUT"));
    }

    public String getName() {
        return this.name;
    }



    public Map<String, Integer> getInventory() {
        return this.inventory;
    }

    public List<ItemTransactionRecordEntry> getTransactionRecord() {
        return this.transactionRecord;
    }
}
