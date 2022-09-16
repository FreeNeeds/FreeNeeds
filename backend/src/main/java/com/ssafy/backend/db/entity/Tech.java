package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tech")
@Getter
@Setter
public class Tech {

    @Id
    @Column(name = "tech_name")
    private String techName;

}
