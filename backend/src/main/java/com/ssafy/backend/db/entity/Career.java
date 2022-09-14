package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "career")
@Getter
@Setter
public class Career {
    @Id
    @GeneratedValue
    private Long careerId;

    private String period;
    private String name;
    private String grade;

    @ManyToOne
    private Resume resume;
}
