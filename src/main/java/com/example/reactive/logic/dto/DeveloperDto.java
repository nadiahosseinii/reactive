package com.example.reactive.logic.dto;

import com.example.reactive.access.domain.Developer;
import com.example.reactive.access.domain.Skill;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeveloperDto {
    Developer developer;
    List<Skill> skills;
}
