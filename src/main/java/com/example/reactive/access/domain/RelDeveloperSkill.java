package com.example.reactive.access.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("rel_developer_skill")
public class RelDeveloperSkill {
    private Long id;
    private Long developerId;
    private Long skillId;

    public RelDeveloperSkill() {
    }

    public RelDeveloperSkill(Long developerId, Long skillId) {
        this.developerId = developerId;
        this.skillId = skillId;
    }

    public RelDeveloperSkill(Long id, Long developerId, Long skillId) {
        this.id = id;
        this.developerId = developerId;
        this.skillId = skillId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(Long developerId) {
        this.developerId = developerId;
    }

    public Long getSkillId() {
        return skillId;
    }

    public void setSkillId(Long skillId) {
        this.skillId = skillId;
    }
}
