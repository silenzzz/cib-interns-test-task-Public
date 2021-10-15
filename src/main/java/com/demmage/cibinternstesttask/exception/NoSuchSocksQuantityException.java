package com.demmage.cibinternstesttask.exception;

/**
 * @author Vadim Guseynov
 */

public class NoSuchSocksQuantityException extends RuntimeException {

    public NoSuchSocksQuantityException() {
        super();
    }

    public NoSuchSocksQuantityException(String message) {
        super(message);
    }

    public NoSuchSocksQuantityException(String message, Throwable cause) {
        super(message, cause);
    }
}