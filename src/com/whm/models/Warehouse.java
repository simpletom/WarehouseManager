package com.whm.models;

import java.util.ArrayList;

public class Warehouse {
    private String name;
    private ArrayList<Item> storedItems;

    public Warehouse(String name) {
        this.name = name;
        this.storedItems= new ArrayList<>();
    }

    public void addItem(Item newItem) {
        Item storedItem = this.findItemByName(newItem.getName());
        if(storedItem != null) {
            // Item in found in storage, update quantity
            int newQuantity = storedItem.getQuantity() + newItem.getQuantity();
            storedItem.setQuantity(newQuantity);
        } else {
            // Item is not in storage, create entry
            this.storedItems.add(newItem);
        }
    }

    public void removeItem(Item item) {
        Item storedItem = this.findItemByName(item.getName());

        if(storedItem != null) {
            int newQuantity = storedItem.getQuantity() - item.getQuantity();
            if(newQuantity < 1) {
                this.deleteItem(storedItem);
            } else {
                storedItem.setQuantity(newQuantity);
            }
        }
    }

    private void deleteItem(Item item) {
        Item storedItem = this.findItemByName(item.getName());
        if(storedItem != null) {
            storedItems.remove(item);
        }
    }

    private Item findItemByName(String name) {
        Item storedItem = null;

        for(Item item : storedItems) {
            if(item.getName() == name) {
                storedItem = item;
            }
        }

        return storedItem;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<Item> getStoredItems() {
        return this.storedItems;
    }
}
