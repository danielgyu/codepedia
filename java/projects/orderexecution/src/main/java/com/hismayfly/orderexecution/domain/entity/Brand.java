package com.hismayfly.orderexecution.domain.entity;

import com.hismayfly.orderexecution.common.jpa.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Brand extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "brand")
    private List<Shoe> shoes = new ArrayList<>();
}
