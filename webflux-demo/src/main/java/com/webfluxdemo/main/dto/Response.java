package com.webfluxdemo.main.dto;

import lombok.Data;
import lombok.ToString;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
@ToString
public class Response {

    private LocalDateTime date = Instant.now().atZone(ZoneId.systemDefault()).toLocalDateTime();
    private Integer output;

    public Response(Integer output) {
        this.output = output;
    }
}
