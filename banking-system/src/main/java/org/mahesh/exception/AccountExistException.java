package org.mahesh.exception;

public class AccountExistException extends Exception {
    public AccountExistException(String errorMessage) {
        super(errorMessage);
    }
}
