package com.hismayfly.orderexecution.infrastructure;

import com.hismayfly.orderexecution.domain.entity.ShoeProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeProductJpaRepository extends JpaRepository<ShoeProduct, Long> {
}
