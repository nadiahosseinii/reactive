package com.example.reactive.logic.service;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.access.domain.RelDeveloperSkill;
import com.example.reactive.access.domain.Skill;
import com.example.reactive.access.repository.DeveloperRepository;
import com.example.reactive.access.repository.RelDeveloperSkillRepository;
import com.example.reactive.access.repository.SkillRepository;
import com.example.reactive.logic.dto.DeveloperDto;
import com.example.reactive.logic.dto.DeveloperSkillDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@AllArgsConstructor
@Service
public class RelDeveloperSkillService {
    private DeveloperRepository developerRepository;
    private SkillRepository skillRepository;
    private RelDeveloperSkillRepository relDeveloperSkillRepository;

    public Mono<DeveloperDto> readDeveloperSkills(Long id) {
        Mono<Developer> developerMono = developerRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Developer not found.")));
        Mono<List<Skill>> skillsMono = relDeveloperSkillRepository.readByDeveloperId(id)
                .flatMap(rel ->
                        skillRepository.findById(rel.getId())
                ).collectList();
        return Mono.zip(developerMono, skillsMono)
                .map(tuple ->
                        new DeveloperDto(tuple.getT1(), tuple.getT2()));
    }

    public Mono<DeveloperSkillDto> saveDeveloperSkills(DeveloperSkillDto dto) {
        Mono<Developer> developer = developerRepository.findById(dto.getDeveloper().getId())
                .switchIfEmpty(Mono.error(new RuntimeException("Developer not found.")));
        Mono<Skill> skill = skillRepository.findById(dto.getSkill().getId())
                .switchIfEmpty(Mono.error(new RuntimeException("Skill not found.")));
        return Mono.zip(developer, skill)
                .flatMap(tuple ->
                        relDeveloperSkillRepository.save(new RelDeveloperSkill(tuple.getT1().getId(), tuple.getT2().getId())))
                .thenReturn(dto);

    }

}
