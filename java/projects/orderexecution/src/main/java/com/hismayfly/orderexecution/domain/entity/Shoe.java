package com.hismayfly.orderexecution.domain.entity;

import com.hismayfly.orderexecution.common.jpa.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
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

    @Builder
    public Shoe(Brand brand, String koreanName, String englishName, String modelNumber, LocalDate releasedAt) {
        this.brand = brand;
        this.koreanName = koreanName;
        this.englishName = englishName;
        this.modelNumber = modelNumber;
        this.releasedAt = releasedAt;
    }
}
