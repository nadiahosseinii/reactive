package com.example.reactive.logic.service;

import com.example.reactive.access.domain.Skill;
import com.example.reactive.access.repository.SkillRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@Service
public class SkillService {
    private SkillRepository skillRepository;

    public Flux<Skill> readAll() {
        return skillRepository.findAll();
    }

    public Mono<Skill> readById(Long id) {
        return skillRepository.findById(id);
    }

    public Mono<Skill> save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Mono<Skill> deleteById(Long id) {
        return skillRepository.findById(id)
                .flatMap(skill ->
                        skillRepository.delete(skill)
                                .thenReturn(skill));
    }
}
