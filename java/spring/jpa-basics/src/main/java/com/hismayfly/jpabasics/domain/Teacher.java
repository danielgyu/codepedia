package com.hismayfly.jpabasics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Teacher {
    @Id @GeneratedValue
    @Column(name = "teacher_id")
    private Long teacherId;

    private String firstName;

    private String lastName;

    //private Course course;
}
