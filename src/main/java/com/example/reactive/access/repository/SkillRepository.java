package com.example.reactive.access.repository;

import com.example.reactive.access.domain.Skill;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkillRepository extends R2dbcRepository<Skill, Long> {
}
