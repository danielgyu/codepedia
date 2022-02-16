package com.hismayfly.jpabasics.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseMaterial {
    @Id @GeneratedValue
    @Column(name = "course_material_id")
    private Long courseMaterialId;

    private String url;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "course_id"
    )
    private Course course;
}
