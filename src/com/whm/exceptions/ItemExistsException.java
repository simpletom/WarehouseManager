package com.whm.exceptions;

public class ItemExistsException extends Throwable {
    public ItemExistsException(String error) {
        super(error);
    }
}
