package com.whm.models;

import com.whm.exceptions.UnknownMovementTypeException;
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

    public void addItemToWarehouse(CustomTimestamp timeStamp, String warehouseName, Item item) throws WarehouseNotFoundException, UnknownMovementTypeException {
        this.moveItem(timeStamp, warehouseName, item, "IN");
    }

    public void removeItemFromWarehouse(CustomTimestamp timeStamp, String warehouseName, Item item) throws WarehouseNotFoundException, UnknownMovementTypeException {
        this.moveItem(timeStamp, warehouseName, item, "OUT");
    }

    private void recordItemMovement(CustomTimestamp timeStamp, String warehouseName, Item item, String movementType) {
        ItemMovementRecordEntry entry = new ItemMovementRecordEntry(timeStamp, warehouseName, movementType, item);
        this.itemMovementRecord.add(entry);
    }

    private void moveItem(CustomTimestamp timeStamp, String warehouseName, Item item, String movementType) throws WarehouseNotFoundException, UnknownMovementTypeException {
        Warehouse warehouse = allWarehouses.get(warehouseName);

        if(warehouse != null) {
            if(movementType.equals("IN")) {
                warehouse.addItem(item);
                this.recordItemMovement(timeStamp, warehouseName, item, movementType);
            } else if(movementType.equals("OUT")) {
                warehouse.removeItem(item);
                this.recordItemMovement(timeStamp, warehouseName, item, movementType);
            } else {
                throw new UnknownMovementTypeException("Unknown movement type: " + movementType);
            }
        } else {
            throw new WarehouseNotFoundException("Warehouse " + warehouseName + " not found");
        }
    }

    public ArrayList<String> getItemMovementRecordAsCSV() {
        ArrayList<String> itemMovementEntries = new ArrayList<>();

        for(ItemMovementRecordEntry recordEntry : this.itemMovementRecord) {
            String entry = recordEntry.getTimeStamp().getTimeStampAsString() + ","
                    + recordEntry.getMovementType() + ","
                    + recordEntry.getWarehouseName() + ","
                    + recordEntry.getItem().getName() + ","
                    + recordEntry.getItem().getQuantity();

            itemMovementEntries.add(entry);
        }

        return itemMovementEntries;
    }
}
