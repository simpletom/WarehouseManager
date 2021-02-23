package com.whm;

import com.whm.exceptions.ItemExistsException;
import com.whm.exceptions.WarehouseExistsException;
import com.whm.exceptions.WarehouseNotFoundException;
import com.whm.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {
    private static WarehouseManager warehouseManager;
    private static ItemManager itemManager;
    private static Warehouse warehouseHamburg;
    private static Warehouse warehouseBerlin;

    private static Item engine;
    private static Item cable;
    private static Item gear;

    public static void main(String[] args) {
        warehouseManager = new WarehouseManager();
        itemManager = new ItemManager();

        // Create warehouses according to example
        setupWarehouses();

        // Create items according to example
        setupItems();

        // execute transactions according to example
        executeTransactions();

        // Print transaction for a specific warehouse
        showTransactions("Hamburg");

        // Print inventory for a specific warehouse
        showInventory("Hamburg");

        // Print transactions for all specified warehouses in chronological order
        List<String> warehouses = new ArrayList<>(Arrays.asList("Hamburg", "Berlin"));
        showChronologicalTransactions(warehouses);
    }

    private static void showChronologicalTransactions(List<String> warehouses) {
        List<ItemTransactionRecordEntry> sortedTransactionEntries = warehouseManager.getChronologicalTransactions(warehouses);
        for(ItemTransactionRecordEntry entry : sortedTransactionEntries) {
            System.out.println(entry.getEntryAsCSV());
        }
    }

    private static void showInventory(String warehouseName) {
        try {
            System.out.println(warehouseManager.getInventory(warehouseName));
        } catch (WarehouseNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void showTransactions(String warehouseName) {
        try {
            List<ItemTransactionRecordEntry> allTransactions = warehouseManager.getTransactionRecord(warehouseName);
            List<String> transactionsAsString = new ArrayList<>();

            for(ItemTransactionRecordEntry entry : allTransactions) {
                transactionsAsString.add(entry.getEntryAsCSV());
            }

            System.out.println(transactionsAsString);
        } catch (WarehouseNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void executeTransactions() {
        warehouseHamburg.addItems(new CustomTimestamp(2019, 03, 01, 15, 53, 00), "engine", 4);
        warehouseBerlin.addItems(new CustomTimestamp(2019, 03, 02, 07, 45, 00), "cable", 500);
        warehouseHamburg.addItems(new CustomTimestamp(2019, 03, 04, 17, 25, 00), "gear", 3);
        warehouseBerlin.addItems(new CustomTimestamp(2019, 03, 04, 18, 17, 00), "engine", 4);
        warehouseBerlin.removeItems(new CustomTimestamp(2019, 03, 05, 9, 12, 00), "cable", 325);
        warehouseHamburg.addItems(new CustomTimestamp(2019, 03, 06, 10, 45, 00), "engine", 2);
        warehouseHamburg.removeItems(new CustomTimestamp(2019, 03, 06, 13, 30, 00), "gear", 1);
        warehouseHamburg.removeItems(new CustomTimestamp(2019, 03, 06, 15, 03, 00), "engine", 2);
    }

    private static void setupWarehouses() {
        warehouseHamburg = new Warehouse("Hamburg");
        warehouseBerlin = new Warehouse("Berlin");

        try {
            warehouseManager.registerWarehouse(warehouseHamburg);
            warehouseManager.registerWarehouse(warehouseBerlin);
        } catch (WarehouseExistsException e) {
            e.printStackTrace();
        }
    }

    private static void setupItems() {
        try {
            engine = itemManager.addItem("engine", 10, "pcs");
            cable = itemManager.addItem("cable", 20, "m");
            gear = itemManager.addItem("gear", 30, "pcs");
        } catch (ItemExistsException e) {
            e.printStackTrace();
        }
    }
}
