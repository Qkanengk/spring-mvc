package com.codegym.ung_dung_muon_sach.exception_handler;

import com.codegym.ung_dung_muon_sach.exception.OutOfStockException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<String> handleOutOfStock(OutOfStockException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    /**
     * Case 2: Xử lý tất cả các lỗi còn lại không lường trước được (NullPointer, SQL Error...)
     * Trả về HTTP Code 500 (Internal Server Error)
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleUnwantedException(Exception e) {
        e.printStackTrace(); // In lỗi ra console để debug
        return new ResponseEntity<>("Lỗi hệ thống: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
