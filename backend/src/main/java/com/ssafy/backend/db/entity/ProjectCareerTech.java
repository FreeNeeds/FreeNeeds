package com.ssafy.backend.db.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "projectCareerTech")
@Getter
@Setter
public class ProjectCareerTech {
    @Id
    @Column(name = "project_career_tech_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectCareerTechId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="projectCareerId", referencedColumnName = "projectCareerId")
    private ProjectCareer projectCareer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tech_name")
    private Tech tech;
}
