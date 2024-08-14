package com.user.ms.exception;

public class SaveFailedException extends RuntimeException {
    public SaveFailedException(String message) {
        super(message);
    }
}
