package com.webfluxdemo.main.service;


import com.webfluxdemo.main.dto.MultiplicationReqDto;
import com.webfluxdemo.main.dto.Response;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ReactiveMathService {

    public Mono<Response> findSquare(Integer num) {
        return Mono.fromSupplier(() -> num * num).map(Response::new);
    }


    public Flux<Response> multiplicationTable(Integer num) {
        return Flux.range(1, 10)
                /*.doOnNext(i -> {

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        })*/.delayElements(Duration.ofSeconds(1)).doOnError(e -> e.printStackTrace()).doOnNext(i -> System.out.println(" Reactive Math Service Processing: " + i)).map(n -> new Response(n * n));
    }

    public Mono<Response> multiplication(Mono<MultiplicationReqDto> req, HttpHeaders headers) {
        System.out.println(headers.get("seleise-key"));
        return req.map(o -> o.getFirstNum() * o.getSecondNum()).map(Response::new);
    }

    public Mono<Response> multiplicationUsingRouter(Mono<MultiplicationReqDto> req, HttpHeaders headers) {
        System.out.println(headers.get("seleise-key"));
        return req.map(o -> o.getFirstNum() * o.getSecondNum()).map(Response::new);
    }

}
