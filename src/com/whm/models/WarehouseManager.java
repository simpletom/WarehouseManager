package com.whm.models;

import com.whm.exceptions.WarehouseExistsException;
import com.whm.exceptions.WarehouseNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;

public class WarehouseManager {
    private HashMap<String, Warehouse> allWarehouses;
    private ArrayList<ItemMovementRecordEntry> itemMovementRecord;

    public WarehouseManager() {
        this.allWarehouses = new HashMap<>();
        this.itemMovementRecord = new ArrayList<>();
    }

    public void registerWarehouse(Warehouse newWarehouse) throws WarehouseExistsException {
        Warehouse wh = allWarehouses.get(newWarehouse.getName());

        if(wh == null) {
            this.allWarehouses.put(newWarehouse.getName(), newWarehouse);
            System.out.println("Warehouse " + newWarehouse.getName() + " registered");
        } else {
            throw new WarehouseExistsException("Warehouse " + newWarehouse.getName() + " already exists");
        }
    }

    public void addItemToWarehouse(CustomTimestamp timeStamp, String warehouseName, Item item) throws WarehouseNotFoundException {
        Warehouse warehouse = allWarehouses.get(warehouseName);

        if(warehouse != null) {
            warehouse.addItem(item);
            this.recordItemMovement(timeStamp, warehouseName, "IN", item);

        } else {
            throw new WarehouseNotFoundException("Warehouse " + warehouseName + " not found");
        }
    }

    public void removeItemFromWarehouse(CustomTimestamp timeStamp, String warehouseName, Item item) throws WarehouseNotFoundException {
        Warehouse warehouse = allWarehouses.get(warehouseName);

        if(warehouse != null) {
            warehouse.removeItem(item);
            this.recordItemMovement(timeStamp, warehouseName, "OUT", item);
        } else {
            throw new WarehouseNotFoundException("Warehouse " + warehouseName + " not found");
        }
    }

    private void recordItemMovement(CustomTimestamp timeStamp, String warehouseName, String movementType, Item item) {
        ItemMovementRecordEntry entry = new ItemMovementRecordEntry(timeStamp, warehouseName, movementType, item);
        this.itemMovementRecord.add(entry);
    }
}
