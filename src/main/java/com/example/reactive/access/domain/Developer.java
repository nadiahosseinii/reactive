package com.example.reactive.access.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("developer")
public class Developer {
    @Id
    @Column("id")
    private Long id;
    @Column("name")
    private String name;

    public Developer() {
    }

    public Developer(String name) {
        this.name = name;
    }

    public Developer(Long id, String name) {
        this.id = id;
        this.name = name;
    }

}
