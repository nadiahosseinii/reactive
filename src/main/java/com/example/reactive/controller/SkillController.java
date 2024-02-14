package com.example.reactive.controller;

import com.example.reactive.access.domain.Skill;
import com.example.reactive.logic.service.SkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/skills")
public class SkillController {
    private SkillService skillService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Skill> readAll() {
        return skillService.readAll();
    }

    @GetMapping("/readById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Skill> readById(@PathVariable Long id) {
        return skillService.readById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Skill> save(@RequestBody Skill skill) {
        return skillService.save(skill);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Skill> deleteById(@PathVariable Long id) {
        return skillService.deleteById(id);
    }
}
