package com.example.reactive.logic.dto;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.access.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DeveloperSkillDto {
    private Developer developer;
    private Skill skill;
}
