package com.example.circuit.breaker.controller;

import com.example.circuit.breaker.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {

    private final AlbumService albumService;

    public CircuitBreakerController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping(value = "/albums")
    private String getAlbums() {
        return albumService.getAlbums();
    }
}
