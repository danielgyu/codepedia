package com.hismayfly.orderexecution.domain.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Entity
public class ShoeProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private Integer size;

    @OneToMany
    @JoinColumn(name = "shoe_product_id")
    private List<ShoePurchaseBid> purchaseBids = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "shoe_product_id")
    private List<ShoeSaleBid> saleBids = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shoe_id")
    private Shoe shoe;

    @Builder
    public ShoeProduct(String color, Integer size) {
        this.color = color;
        this.size = size;
    }
}
