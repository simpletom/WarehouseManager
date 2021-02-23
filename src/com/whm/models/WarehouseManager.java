package com.whm.models;

import com.whm.exceptions.WarehouseExistsException;
import com.whm.exceptions.WarehouseNotFoundException;

import java.util.*;

/**
 * The WarehouseManager is responsible for registering and managing warehouses
 */

public class WarehouseManager {
    private Map<String, Warehouse> allWarehouses;

    public WarehouseManager() {
        this.allWarehouses = new HashMap<>();
    }

    public void registerWarehouse(Warehouse newWarehouse) throws WarehouseExistsException {
        if(allWarehouses.containsKey(newWarehouse.getName())) {
            throw new WarehouseExistsException("Warehouse " + newWarehouse.getName() + " already exists");
        } else {
            this.allWarehouses.put(newWarehouse.getName(), newWarehouse);
        }
    }

    public Warehouse getWarehouse(String warehouseName) throws WarehouseNotFoundException {
        Warehouse warehouse = this.allWarehouses.get(warehouseName);
        if(warehouse == null) {
            throw new WarehouseNotFoundException(warehouseName + " not found");
        }

        return warehouse;
    }

    public List<String> getAllWarehouseNames() {
        List<String> allNames = new ArrayList<>();
        for(String name : this.allWarehouses.keySet()) {
            allNames.add(name);
        }

        return allNames;
    }

    public List<ItemTransactionRecordEntry> getChronologicalTransactions(List<String> warehouseNames) {
        List<Warehouse> warehouses = new ArrayList<>();

        // The warehouses are retrieved by their name
        for(String warehouseName : warehouseNames) {
            if(this.allWarehouses.containsKey(warehouseName)) {
                warehouses.add(this.allWarehouses.get(warehouseName));
            }
        }

        List<ItemTransactionRecordEntry> allTransactionRecordsSorted = new ArrayList<>();

        // All transaction records are added to a singe list
        for(Warehouse warehouse : warehouses) {
            allTransactionRecordsSorted.addAll(warehouse.getTransactionRecord());
        }

        // The list gets sorted according to the timestamp
        Collections.sort(allTransactionRecordsSorted);

        return allTransactionRecordsSorted;
    }
}
