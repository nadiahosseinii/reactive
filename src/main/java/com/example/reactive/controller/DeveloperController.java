package com.example.reactive.controller;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.logic.service.DeveloperService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@CrossOrigin("http://localhost:8080")
@RestController
@RequestMapping("/api/courses")
public class DeveloperController {
    private DeveloperService service;

    @GetMapping("/readById")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Developer> readById(Long id) {
        return service.readById(id);
    }
}
