package com.webfluxdemo.main.dto;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class MultiplicationValidationResponse {

    private Integer errorCode;
    private String msg;
    private int input;
}
