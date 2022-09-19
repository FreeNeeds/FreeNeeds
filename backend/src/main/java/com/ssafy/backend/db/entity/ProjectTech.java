package com.ssafy.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "projectTech")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProjectTech {

    @Id
    @Column(name = "project_tech_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long projectTechId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="projectId", referencedColumnName = "projectId")
    private Project project;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tech_name")
    private Tech tech;
}
