package com.hismayfly.jpabasics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Course {
    @Id @GeneratedValue
    @Column(name = "course_id")
    private Long courseId;

    private String title;

    private Integer credit;

    //private CourseMaterial courseMaterial;

    //private Teacher teacher;
}
