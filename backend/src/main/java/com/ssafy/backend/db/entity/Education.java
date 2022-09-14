package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "education")
@Getter
@Setter
public class Education {
    @Id
    @GeneratedValue
    private Long bachelorId;

    private String period;
    private String name;

    @ManyToOne
    private Resume resume;
}
