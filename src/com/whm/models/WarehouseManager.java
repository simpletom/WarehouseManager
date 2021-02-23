package com.whm.models;

import com.whm.exceptions.UnknownMovementTypeException;
import com.whm.exceptions.WarehouseExistsException;
import com.whm.exceptions.WarehouseNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class WarehouseManager {
    private Map<String, Warehouse> allWarehouses;

    public WarehouseManager() {
        this.allWarehouses = new HashMap<>();
    }

    public void registerWarehouse(Warehouse newWarehouse) throws WarehouseExistsException {
        if(allWarehouses.containsKey(newWarehouse.getName())) {
            this.allWarehouses.put(newWarehouse.getName(), newWarehouse);
            System.out.println("Warehouse " + newWarehouse.getName() + " registered");
        } else {
            throw new WarehouseExistsException("Warehouse " + newWarehouse.getName() + " already exists");
        }
    }

    public void addItemsToWarehouse(CustomTimestamp timeStamp, String warehouseName, String itemName, int quantity)
            throws WarehouseNotFoundException, UnknownMovementTypeException {
        this.moveItem(timeStamp, warehouseName, itemName, quantity, "IN");
    }

    public void removeItemsFromWarehouse(CustomTimestamp timeStamp, String warehouseName, String itemName, int quantity)
            throws WarehouseNotFoundException, UnknownMovementTypeException {
        this.moveItem(timeStamp, warehouseName, itemName, quantity, "OUT");
    }

    private void moveItem(CustomTimestamp timeStamp, String warehouseName, String itemName, int quantity, String movementType)
            throws WarehouseNotFoundException, UnknownMovementTypeException {

        Warehouse warehouse = this.allWarehouses.get(warehouseName);

        if(warehouse != null) {
            if(movementType.equals("IN")) {
                warehouse.addItems(timeStamp, itemName, quantity);
            } else if(movementType.equals("OUT")) {
                warehouse.removeItems(timeStamp, itemName, quantity);
            } else {
                throw new UnknownMovementTypeException("Unknown movement type: " + movementType);
            }
        } else {
            throw new WarehouseNotFoundException("Warehouse " + warehouseName + " not found");
        }
    }
}
