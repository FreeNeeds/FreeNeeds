package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tech")
@Getter
@Setter
public class Tech {
    @Id
    @GeneratedValue
    private Long techId;

    private String name;

    @ManyToOne
    private Resume resume;

}
