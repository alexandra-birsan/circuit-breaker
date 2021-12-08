package com.example.circuit.breaker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class CircuitBreakerController {

    @GetMapping(value = "/hello")
    private Mono<String> sayHello() {
        return Mono.just("Hi, I'm Alex!");
    }
}
