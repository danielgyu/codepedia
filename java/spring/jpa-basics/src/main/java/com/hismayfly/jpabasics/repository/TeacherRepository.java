package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
