package com.aeon.librarysystem.dto.response;

import com.aeon.librarysystem.constant.ApiConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private int code;
    private String status;
    private String message;
    private T data;
    private LocalDateTime timestamp;

    public static <T> ApiResponse<T> success(int code, T data) {
        return new ApiResponse<>(code, ApiConstants.STATUS_SUCCESS, null, data, LocalDateTime.now());
    }

    public static <T> ApiResponse<T> error(int code, String message) {
        return new ApiResponse<>(code, ApiConstants.STATUS_ERROR, message, null, LocalDateTime.now());
    }
}