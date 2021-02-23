package com.whm.models;

import com.whm.exceptions.ItemExistsException;
import com.whm.exceptions.ItemNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ItemManager {
    private Map<String, Item> allItems;

    public ItemManager() {
        this.allItems = new HashMap<>();
    }

    public Item addItem(String itemName, int basePrice, String unitType) throws ItemExistsException {
        if(this.allItems.containsKey(itemName)) {
            throw new ItemExistsException(itemName + " already exists");
        } else {
            Item item = new Item(itemName, basePrice, unitType);
            this.allItems.put(itemName, item);
            return item;
        }
    }

    public void removeItem(String itemName) {
        if(this.allItems.containsKey(itemName)) {
            this.allItems.remove(itemName);
        }
    }

    public Item getItemByName(String itemName) throws ItemNotFoundException {
        Item item = this.allItems.get(itemName);
        if(item != null) {
            return item;
        } else {
            throw new ItemNotFoundException(itemName + " not found");
        }
    }
}
