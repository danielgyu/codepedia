package com.hismayfly.orderexecution.domain.entity;

import com.hismayfly.orderexecution.common.jpa.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Shoe extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "shoe")
    private List<ShoeProduct> shoeProducts = new ArrayList<>();

    @Column(name = "korean_name", nullable = false)
    private String koreanName;

    @Column(name = "english_name", nullable = true)
    private String englishName;

    @Column(name = "model_number", nullable = true)
    private String modelNumber;

    @Column(name = "released_at", nullable = true)
    private LocalDate releasedAt;
}
