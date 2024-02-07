package com.example.reactive.access.repository;

import com.example.reactive.access.domain.Developer;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface DeveloperRepository extends R2dbcRepository<Developer, Long> {
    public Flux<Developer> readByName(String name);
}
