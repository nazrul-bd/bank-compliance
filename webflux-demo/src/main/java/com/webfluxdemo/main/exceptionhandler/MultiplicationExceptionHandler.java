package com.webfluxdemo.main.exceptionhandler;

import com.webfluxdemo.main.dto.MultiplicationValidationResponse;
import com.webfluxdemo.main.exception.MultiplicationValidationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MultiplicationExceptionHandler {


    @ExceptionHandler(MultiplicationValidationException.class)
    public ResponseEntity<MultiplicationValidationResponse> handleMultiplicationException(MultiplicationValidationException ex) {

        MultiplicationValidationResponse response = new MultiplicationValidationResponse();
        response.setInput(ex.getInput());
        response.setErrorCode(ex.getErrorCode());
        response.setMsg(ex.getMessage());
        return ResponseEntity.badRequest().body(response);
    }
}
