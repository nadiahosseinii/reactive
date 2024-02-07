package com.example.reactive.access.repository;

import com.example.reactive.access.domain.RelDeveloperSkill;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelDeveloperSkillRepository extends R2dbcRepository<RelDeveloperSkill, Long> {
}
