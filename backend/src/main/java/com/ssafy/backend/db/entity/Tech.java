package com.ssafy.backend.db.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tech")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tech {

    @Id
    @Column(name = "tech_name",length = 50)
    private String techName;

}
