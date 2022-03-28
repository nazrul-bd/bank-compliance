package com.webfluxdemo.main.exception;


import lombok.Getter;

@Getter
public class MultiplicationValidationException extends RuntimeException {

    public static final String msg = "Allowed range is 10-20";
    private final int input;
    private final int errorCode = 100;

    public MultiplicationValidationException(int input) {
        super(msg);
        this.input = input;
    }
}
