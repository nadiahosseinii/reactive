package com.example.reactive.logic.service;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.access.repository.DeveloperRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DeveloperService {
    private DeveloperRepository repo;

    public Flux<Developer> readAll() {
        return repo.findAll();
    }

    public Mono<Developer> readById(Long id) {
        return repo.findById(id);
    }

    public Flux<Developer> readByName(String name) {
        return repo.readByName(name);
    }

    public Mono<Developer> save(Developer developer) {
        return repo.save(developer);
    }

    public Mono<Developer> deleteById(Long id) {
        return repo.findById(id)
                .flatMap(developer ->
                        repo.delete(developer)
                                .thenReturn(developer));
    }

}
