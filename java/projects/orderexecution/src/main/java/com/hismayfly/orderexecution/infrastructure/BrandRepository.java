package com.hismayfly.orderexecution.infrastructure;

import com.hismayfly.orderexecution.domain.entity.Brand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BrandRepository {

    @Autowired
    private BrandJpaRepository brandJpaRepository;

    public Brand getBrandByName(String brandName) {
        return brandJpaRepository.findByName(brandName);
    }
}
