package com.aeon.librarysystem.exception;

import com.aeon.librarysystem.constant.ApiConstants;

public class BookNotFoundException extends LibraryException {
    public BookNotFoundException() {
        super(ApiConstants.BOOK_NOT_FOUND_CODE, "Book not found");
    }
}
