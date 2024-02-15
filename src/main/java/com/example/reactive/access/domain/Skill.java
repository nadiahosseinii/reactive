package com.example.reactive.access.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("skill")
public class Skill {
    @Id
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

}
