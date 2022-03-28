package com.webfluxdemo.main.controller;

import com.webfluxdemo.main.dto.MultiplicationReqDto;
import com.webfluxdemo.main.dto.Response;
import com.webfluxdemo.main.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathController {

    @Autowired
    private ReactiveMathService mathService;

    @GetMapping(path = "/square/{inp}")
    public Mono<Response> findSquare(@PathVariable(name = "inp") Integer input) {
        return mathService.findSquare(input);
    }

    @GetMapping(path = "/table/{inp}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTable(@PathVariable(name = "inp") Integer input) {
        return mathService.multiplicationTable(input);
    }

    @PostMapping(path = "/multiply", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Response> multiplication(@RequestBody Mono<MultiplicationReqDto> req, @RequestHeader HttpHeaders headers) {
        return mathService.multiplication(req, headers);
    }

    @PostMapping(path = "/router/square/{input}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Response> multiplicationUsingRouter(@RequestBody Mono<MultiplicationReqDto> req, @RequestHeader HttpHeaders headers) {
        return mathService.multiplicationUsingRouter(req, headers);
    }

    @GetMapping(path = "/router/table/{inp}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Response> multiplicationTableRouter(@PathVariable(name = "inp") Integer input) {
        return mathService.multiplicationTable(input);
    }
}
