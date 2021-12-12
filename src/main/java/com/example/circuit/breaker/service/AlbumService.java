package com.example.circuit.breaker.service;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

  private final CircuitBreakerFactory circuitBreakerFactory;
  private final RestTemplate restTemplate = new RestTemplate();

  public AlbumService(CircuitBreakerFactory circuitBreakerFactory) {
    this.circuitBreakerFactory = circuitBreakerFactory;
  }

  public String getAlbums() {
    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitBreaker");
    String url = "https://jsonplaceholder.typicode.com/albums";

    return circuitBreaker.run(
        () -> restTemplate.getForObject(url, String.class), throwable -> "Empty albums list!");
  }
}
