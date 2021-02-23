package com.whm;

import com.whm.exceptions.WarehouseExistsException;
import com.whm.models.Item;
import com.whm.models.Warehouse;
import com.whm.models.WarehouseManager;

public class main {
    private static WarehouseManager whManager;
    private static Warehouse warehouseHamburg;
    private static Warehouse warehouseBerlin;

    private static Item engine;
    private static Item cable;
    private static Item gear;

    public static void main(String[] args) {
        whManager = new WarehouseManager();
        setupWarehouses();
        setupItems();

    }

    private static void setupWarehouses() {
        warehouseHamburg = new Warehouse("Hamburg");
        warehouseBerlin = new Warehouse("Berlin");

        try {
            whManager.registerWarehouse(warehouseHamburg);
            whManager.registerWarehouse(warehouseBerlin);
        } catch (WarehouseExistsException e) {
            e.printStackTrace();
        }
    }

    private static void setupItems() {

    }
}
