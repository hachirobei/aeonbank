package com.aeon.librarysystem.exception;

import com.aeon.librarysystem.constant.ApiConstants;
import com.aeon.librarysystem.dto.response.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(LibraryException.class)
    public ApiResponse<String> handleLibraryException(LibraryException ex) {
        logger.error("LibraryException occurred: {}", ex.getMessage());

        return ApiResponse.error(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    public ApiResponse<String> handleRuntimeException(RuntimeException ex) {
        logger.error("RuntimeException occurred: {}", ex.getMessage());

        return ApiResponse.error(ApiConstants.BAD_REQUEST_CODE, "An unexpected error occurred.");
    }
}