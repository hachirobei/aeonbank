package com.aeon.librarysystem.exception;

import com.aeon.librarysystem.constant.ApiConstants;

public class BookAlreadyBorrowedException extends LibraryException {
    public BookAlreadyBorrowedException() {
        super(ApiConstants.BOOK_ALREADY_BORROWED_CODE, "Book is already borrowed");
    }
}