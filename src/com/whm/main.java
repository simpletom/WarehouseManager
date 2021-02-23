package com.whm;

import com.whm.exceptions.WarehouseExistsException;
import com.whm.models.Item;
import com.whm.models.Warehouse;
import com.whm.models.WarehouseManager;

import java.util.Date;

public class main {
    private static WarehouseManager whManager;
    private static Warehouse whHamburg;
    private static Warehouse whBerlin;

    private static Item engine;
    private static Item cable;
    private static Item gear;

    public static void main(String[] args) {
        whManager = new WarehouseManager();
        setupWarehouses();
        setupItems();

    }

    private static void setupWarehouses() {
        whHamburg = new Warehouse("Hamburg");
        whBerlin = new Warehouse("Berlin");

        try {
            whManager.registerWarehouse(whHamburg);
            whManager.registerWarehouse(whBerlin);
        } catch (WarehouseExistsException e) {
            e.printStackTrace();
        }
    }

    private static void setupItems() {

    }
}
