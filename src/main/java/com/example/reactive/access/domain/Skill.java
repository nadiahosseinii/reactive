package com.example.reactive.access.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("skill")
public class Skill {
    @Column("id")
    private Long id;
    @Column("title")
    private String title;

    public Skill() {
    }

    public Skill(String name) {
        this.title = name;
    }

    public Skill(Long id, String name) {
        this.id = id;
        this.title = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
