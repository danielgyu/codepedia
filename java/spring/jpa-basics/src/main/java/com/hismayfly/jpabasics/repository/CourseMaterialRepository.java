package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial, Long> {

    CourseMaterial findByUrl(String url);
}
