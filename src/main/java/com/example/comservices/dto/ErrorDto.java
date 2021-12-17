package com.example.comservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Date;

@Data
@AllArgsConstructor
public class ErrorDto {

    private String message;
    private Date timestamp;
}
