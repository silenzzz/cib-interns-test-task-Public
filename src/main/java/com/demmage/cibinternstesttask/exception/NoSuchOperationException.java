package com.demmage.cibinternstesttask.exception;

/**
 * @author Vadim Guseynov
 */

public class NoSuchOperationException extends RuntimeException {

    public NoSuchOperationException() {
        super();
    }

    public NoSuchOperationException(String message) {
        super(message);
    }

    public NoSuchOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}