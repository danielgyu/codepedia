package com.hismayfly.jpabasics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CourseMaterial {
    @Id @GeneratedValue
    @Column(name = "course_material_id")
    private Long courseMaterialId;

    private String url;

    //private Course course;
}
