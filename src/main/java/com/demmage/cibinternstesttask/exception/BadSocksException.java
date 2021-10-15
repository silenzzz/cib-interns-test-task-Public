package com.demmage.cibinternstesttask.exception;

/**
 * @author Vadim Guseynov
 */

public class BadSocksException extends RuntimeException {

    public BadSocksException() {
        super();
    }

    public BadSocksException(String message) {
        super(message);
    }

    public BadSocksException(String message, Throwable cause) {
        super(message, cause);
    }
}
