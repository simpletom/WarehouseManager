package com.whm.models;

import java.util.List;

public class WarehouseTransactionRecord {
    private String warehouseName;
    private List<ItemTransactionRecordEntry> transactionRecords;

    public WarehouseTransactionRecord(String warehouseName, List<ItemTransactionRecordEntry> transactionRecords) {
        this.warehouseName = warehouseName;
        this.transactionRecords = transactionRecords;
    }
}
