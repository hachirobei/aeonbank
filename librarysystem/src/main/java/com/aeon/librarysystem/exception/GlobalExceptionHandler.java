package com.aeon.librarysystem.exception;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.dto.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(BookNotBorrowedException.class)
    public ApiResponse<String> handleBookNotBorrowedException(BookNotBorrowedException ex) {
        logger.error("BookNotBorrowedException occurred: {}", ex.getMessage());
        return ApiResponse.error(ApiConstants.BOOK_NOT_BORROWED_CODE, ex.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ApiResponse<String> handleBookNotFoundException(BookNotFoundException ex) {
        logger.error("BookNotFoundException occurred: {}", ex.getMessage());
        return ApiResponse.error(ApiConstants.BOOK_NOT_FOUND_CODE, "Book not found.");
    }

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ApiResponse<String> handleBookAlreadyExistsException(BookAlreadyExistsException ex) {
        logger.error("BookAlreadyExistsException occurred: {}", ex.getMessage());
        return ApiResponse.error(ApiConstants.BAD_REQUEST_CODE, ex.getMessage());
    }

    @ExceptionHandler(InvalidBookDetailsException.class)
    public ApiResponse<String> handleInvalidBookDetailsException(InvalidBookDetailsException ex) {
        logger.error("InvalidBookDetailsException occurred: {}", ex.getMessage());
        return ApiResponse.error(ApiConstants.BAD_REQUEST_CODE, ex.getMessage());
    }

    @ExceptionHandler(LibraryException.class)
    public ApiResponse<String> handleLibraryException(LibraryException ex) {
        logger.error("LibraryException occurred: {}", ex.getMessage());
        return ApiResponse.error(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<String> handleRuntimeException(RuntimeException ex) {
        logger.error("RuntimeException occurred: {}", ex.getMessage(), ex);
        return ApiResponse.error(ApiConstants.BAD_REQUEST_CODE, "An unexpected error occurred.");
    }

    // Handle request validation exceptions
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ApiResponse<String> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldError() != null
                ? ex.getBindingResult().getFieldError().getDefaultMessage()
                : "Validation error";
        logger.error("Validation error: {}", errorMessage);
        return ApiResponse.error(ApiConstants.BAD_REQUEST_CODE, errorMessage);
    }
}