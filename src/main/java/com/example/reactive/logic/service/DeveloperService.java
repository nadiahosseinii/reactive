package com.example.reactive.logic.service;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.access.repository.DeveloperRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class DeveloperService {
    private DeveloperRepository developerRepository;

    public Flux<Developer> readAll() {
        return developerRepository.findAll();
    }

    public Mono<Developer> readById(Long id) {
        return developerRepository.findById(id);
    }

    public Mono<Developer> save(Developer developer) {
        return developerRepository.save(developer);
    }

    public Mono<Developer> deleteById(Long id) {
        return developerRepository.findById(id)
                .flatMap(developer ->
                        developerRepository.delete(developer)
                                .thenReturn(developer));
    }

}
