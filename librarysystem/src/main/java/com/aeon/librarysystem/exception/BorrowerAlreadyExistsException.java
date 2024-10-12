package com.aeon.librarysystem.exception;

public class BorrowerAlreadyExistsException extends RuntimeException {
    public BorrowerAlreadyExistsException(String message) {
        super(message);
    }
}