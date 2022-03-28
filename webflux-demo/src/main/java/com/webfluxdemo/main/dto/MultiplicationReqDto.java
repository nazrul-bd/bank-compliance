package com.webfluxdemo.main.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;

@Data
@ToString
public class MultiplicationReqDto {

    private Long date = Instant.now().toEpochMilli();
    private Integer firstNum;
    private Integer secondNum;
}
