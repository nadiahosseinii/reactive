package com.example.reactive.controller;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.logic.dto.DeveloperDto;
import com.example.reactive.logic.dto.DeveloperSkillDto;
import com.example.reactive.logic.service.DeveloperService;
import com.example.reactive.logic.service.RelDeveloperSkillService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@AllArgsConstructor
@CrossOrigin("http://localhost:8081")
@RestController
@RequestMapping("/api/developer")
public class DeveloperController {
    private DeveloperService developerService;
    private RelDeveloperSkillService relDeveloperSkillService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public Flux<Developer> readAll() {
        return developerService.readAll();
    }

    @GetMapping("/readById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Developer> readById(@PathVariable Long id) {
        return developerService.readById(id);
    }

    @GetMapping("readSkillsById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DeveloperDto> readSkillsById(@PathVariable Long id) {
        return relDeveloperSkillService.readDeveloperSkills(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Developer> save(@RequestBody Developer developer) {
        return developerService.save(developer);
    }

    @PostMapping("/saveSkill")
    @ResponseStatus(HttpStatus.OK)
    public Mono<DeveloperSkillDto> saveSkills(DeveloperSkillDto dto) {
        return relDeveloperSkillService.saveDeveloperSkills(dto);
    }

    @DeleteMapping("/deleteById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Developer> deleteById(@PathVariable Long id) {
        return developerService.deleteById(id);
    }
}
