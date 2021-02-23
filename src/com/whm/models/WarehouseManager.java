package com.whm.models;

import com.whm.exceptions.WarehouseExistsException;
import com.whm.exceptions.WarehouseNotFoundException;

import java.util.*;

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

    public List<ItemTransactionRecordEntry> getTransactionRecord(String warehouseName) throws WarehouseNotFoundException {
        if(this.allWarehouses.containsKey(warehouseName)) {
            return this.allWarehouses.get(warehouseName).getTransactionRecord();
        } else {
            throw new WarehouseNotFoundException(warehouseName + " not found");
        }
    }

    public List<ItemTransactionRecordEntry> getChronologicalTransactions(List<String> warehouseNames) {
        List<Warehouse> warehouses = new ArrayList<>();

        for(String warehouseName : warehouseNames) {
            if(this.allWarehouses.containsKey(warehouseName)) {
                warehouses.add(this.allWarehouses.get(warehouseName));
            }
        }

        List<ItemTransactionRecordEntry> allTransactionRecordsSorted = new ArrayList<>();

        for(Warehouse warehouse : warehouses) {
            allTransactionRecordsSorted.addAll(warehouse.getTransactionRecord());
        }

        Collections.sort(allTransactionRecordsSorted);

        return allTransactionRecordsSorted;
    }

    public Map<String, Integer> getInventory(String warehouseName) throws WarehouseNotFoundException {
        Warehouse warehouse = this.allWarehouses.get(warehouseName);

        if(warehouse == null) {
            throw new WarehouseNotFoundException(warehouseName + " not found");
        } else {
            return warehouse.getInventory();
        }
    }
}
