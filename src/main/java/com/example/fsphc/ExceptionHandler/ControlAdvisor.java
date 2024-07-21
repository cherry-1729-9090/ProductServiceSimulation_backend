package com.example.fsphc.ExceptionHandler;

import com.example.productservice_dc_05.Exception.ProductNotFoundException;
import com.example.productservice_dc_05.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControlAdvisor {
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException productNotFoundException){
        ExceptionDto  dto = new ExceptionDto();
        dto.setMessage("Invalid ProductId :"+ productNotFoundException.getId() +"Product Not found");
        dto.setResolution("Provide a valid ProductId");
        ResponseEntity<ExceptionDto> response = new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
        return response;
    }
}
