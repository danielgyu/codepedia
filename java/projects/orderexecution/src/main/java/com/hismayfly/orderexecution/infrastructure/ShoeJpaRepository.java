package com.hismayfly.orderexecution.infrastructure;

import com.hismayfly.orderexecution.domain.entity.Shoe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeJpaRepository extends JpaRepository<Shoe, Long> {
}
