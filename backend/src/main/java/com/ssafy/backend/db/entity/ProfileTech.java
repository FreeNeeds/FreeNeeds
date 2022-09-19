package com.ssafy.backend.db.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "profileTech")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProfileTech {

    @Id
    @Column(name = "profile_tech_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileTechId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="profileId", referencedColumnName = "profileId")
    private Profile profile;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="tech_name")
    private Tech tech;
}
