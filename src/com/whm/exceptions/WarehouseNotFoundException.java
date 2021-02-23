package com.whm.exceptions;

public class WarehouseNotFoundException extends Exception {
    public WarehouseNotFoundException(String error) {
        super(error);
    }
}
