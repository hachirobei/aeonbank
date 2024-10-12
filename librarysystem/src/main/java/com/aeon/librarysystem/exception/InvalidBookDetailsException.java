package com.aeon.librarysystem.exception;

public class InvalidBookDetailsException extends RuntimeException {
    public InvalidBookDetailsException(String message) {
        super(message);
    }
}