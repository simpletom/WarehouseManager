package com.whm.exceptions;

public class WarehouseExistsException extends Throwable {
    public WarehouseExistsException(String error) {
        super(error);
    }
}
