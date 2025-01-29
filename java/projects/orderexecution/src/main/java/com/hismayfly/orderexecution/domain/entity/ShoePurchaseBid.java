package com.hismayfly.orderexecution.domain.entity;

import com.hismayfly.orderexecution.common.jpa.BaseEntity;
import jakarta.persistence.*;

@Entity
public class ShoePurchaseBid extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "desired_purchase_price", nullable = false)
    private Long desiredPurchasePrice;

    // INFO: dont' add user_id, product_detail_id relationships, explore other ways
}
