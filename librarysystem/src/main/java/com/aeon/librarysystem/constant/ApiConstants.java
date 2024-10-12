package com.aeon.librarysystem.constant;

public class ApiConstants {

    private ApiConstants() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static final int SUCCESS_CODE = 200;
    public static final int CREATED_CODE = 201;

    public static final int BOOK_NOT_FOUND_CODE = 40401;
    public static final int BOOK_ALREADY_BORROWED_CODE = 40001;
    public static final int BOOK_NOT_BORROWED_CODE = 40002;
    public static final int BAD_REQUEST_CODE = 400;

    public static final String STATUS_SUCCESS = "SUCCESS";
    public static final String STATUS_ERROR = "ERROR";
}
