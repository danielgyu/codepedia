package com.hismayfly.orderexecution.infrastructure;

import com.hismayfly.orderexecution.domain.entity.Shoe;
import com.hismayfly.orderexecution.domain.entity.ShoeProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShoeRepository {

    @Autowired
    private ShoeJpaRepository shoeJpaRepository;

    @Autowired
    private ShoeProductJpaRepository shoeProductJpaRepository;

    public void save(Shoe shoe, List<ShoeProduct> shoeProducts) {
        shoeJpaRepository.save(shoe);
        shoeProductJpaRepository.saveAll(shoeProducts);
    }
}
