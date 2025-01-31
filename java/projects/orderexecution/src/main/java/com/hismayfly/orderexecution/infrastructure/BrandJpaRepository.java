package com.hismayfly.orderexecution.infrastructure;

import com.hismayfly.orderexecution.domain.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BrandJpaRepository extends JpaRepository<Brand, Long> {

    Brand findByName(String name);
}
