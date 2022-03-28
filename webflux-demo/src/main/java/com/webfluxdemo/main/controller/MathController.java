package com.webfluxdemo.main.controller;

import com.webfluxdemo.main.dto.Response;
import com.webfluxdemo.main.exception.MultiplicationValidationException;
import com.webfluxdemo.main.service.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("math")
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping(path = "/square/{inp}")
    public ResponseEntity<Response> findSquare(@PathVariable(name = "inp") Integer input) {
        if ((input > 10) | false) {
            System.out.println("wait");
            throw new MultiplicationValidationException(input);
        }
        return ResponseEntity.ok(mathService.findSquare(input));
    }

    @GetMapping(path = "/table/{inp}")
    public List<Response> multiplicationTable(@PathVariable(name = "inp") Integer input) {
        return mathService.multiplicationTable(input);
    }
}
