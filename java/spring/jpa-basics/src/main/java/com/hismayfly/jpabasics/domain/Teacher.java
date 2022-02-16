package com.hismayfly.jpabasics.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Teacher {
    @Id @GeneratedValue
    @Column(name = "teacher_id")
    private Long teacherId;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "teacher")
    private List<Course> course;
}
