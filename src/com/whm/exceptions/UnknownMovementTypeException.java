package com.whm.exceptions;

public class UnknownMovementTypeException extends Throwable {
    public UnknownMovementTypeException(String error) {
        super(error);
    }
}
