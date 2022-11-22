package com.ssafy.backend.db.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "domain")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Domain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long domainId;

    @Column(name = "domain_name",length = 50)
    private String domainName;



    @ManyToOne
    @JoinColumn(name="projectId", referencedColumnName = "projectId")
    @Cascade(org.hibernate.annotations.CascadeType.DETACH)
    private Project project;

}
