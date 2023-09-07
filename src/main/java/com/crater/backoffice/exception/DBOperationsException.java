package com.crater.backoffice.exception;

public class DBOperationsException extends RuntimeException{
    public DBOperationsException(String message) {
        super(message);
    }

    public DBOperationsException(String message, Throwable cause) {
        super(message, cause);
    }
}
