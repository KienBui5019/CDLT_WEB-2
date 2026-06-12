package com.buiduykien.etech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // Tự động trả về mã lỗi 404 cho giao diện ReactJS
public class ResourceNotFoundException extends RuntimeException {
    
    // BẮT BUỘC: Phải có hàm khởi tạo nhận tham số String message này
    public ResourceNotFoundException(String message) {
        super(message);
    }
}