package com.findwise.exception;

public class ExitApplicationException extends Exception {
    public ExitApplicationException() {
        super();
    }

    public ExitApplicationException(String message) {
        super(message);
    }
}
