package com.demmage.cibinternstesttask.exception;

/**
 * @author Vadim Guseynov
 */

public class SocksNotFoundException extends RuntimeException {

    public SocksNotFoundException() {
        super();
    }

    public SocksNotFoundException(String message) {
        super(message);
    }

    public SocksNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}