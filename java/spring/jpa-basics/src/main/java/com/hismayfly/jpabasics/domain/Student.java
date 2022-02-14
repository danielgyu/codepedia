package com.hismayfly.jpabasics.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(uniqueConstraints = @UniqueConstraint(
        name = "email_unique",
        columnNames = "email_address"
))
public class Student {
    @Id @GeneratedValue
    @Column(name = "student_id")
    private Long studentId;

    private String firstName;

    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String email;

    @Embedded
    private Guardian guardian;
}
