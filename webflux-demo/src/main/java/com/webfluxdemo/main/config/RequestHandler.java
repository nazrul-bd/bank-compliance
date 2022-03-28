package com.webfluxdemo.main.config;

import com.webfluxdemo.main.dto.Response;
import com.webfluxdemo.main.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class RequestHandler {

    @Autowired
    private ReactiveMathService mathService;

    public Mono<ServerResponse> squareHandler(ServerRequest serverRequest) {

        int inputNumber = Integer.parseInt(serverRequest.pathVariable("inp"));
        Mono<Response> responseMono = this.mathService.findSquare(inputNumber);
        return ServerResponse.ok().body(responseMono, Response.class);
    }

    public Mono<ServerResponse> multiplicationTableHandler(ServerRequest serverRequest) {

        int inputNumber = Integer.parseInt(serverRequest.pathVariable("inp"));
        Flux<Response> responseMono = this.mathService.multiplicationTable(inputNumber);
        return ServerResponse.ok().body(responseMono, Response.class);
    }
}
