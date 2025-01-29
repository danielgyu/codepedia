package com.hismayfly.orderexecution.domain.entity;

import com.hismayfly.orderexecution.common.jpa.BaseEntity;
import jakarta.persistence.*;

@Entity
public class ShoeSaleBid extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "desired_sale_price", nullable = false)
    private Long desiredSalePrice;

    // INFO: dont' add user_id, product_detail_id relationships, explore other ways
}
