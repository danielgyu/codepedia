package com.hismayfly.orderexecution.domain.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "kuser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String name;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ShoePurchaseBid> purchaseBids = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<ShoeSaleBid> saleBids = new ArrayList<>();
}
