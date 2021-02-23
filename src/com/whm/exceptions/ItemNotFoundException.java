package com.whm.exceptions;

public class ItemNotFoundException extends Throwable {
    public ItemNotFoundException(String error) {
        super(error);
    }
}
