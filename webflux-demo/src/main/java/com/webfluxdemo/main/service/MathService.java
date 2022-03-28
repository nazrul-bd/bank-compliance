package com.webfluxdemo.main.service;


import com.webfluxdemo.main.dto.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class MathService {

    public Response findSquare(Integer num) {
        return new Response(num * num);
    }

    public List<Response> multiplicationTable(Integer num) {
        return IntStream.rangeClosed(1, 10).peek(i -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).peek(i -> System.out.println("Math Service Processing: " + i)).mapToObj(n -> new Response(n * n)).collect(Collectors.toList());
    }

}
