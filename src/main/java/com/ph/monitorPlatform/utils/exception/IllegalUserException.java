package com.ph.monitorPlatform.utils.exception;

public class IllegalUserException extends RuntimeException {

    public IllegalUserException() {
    }

    public IllegalUserException(String message) {
        super(message);
    }

    public IllegalUserException(String message, Throwable cause) {
        super(message, cause);
    }
}
