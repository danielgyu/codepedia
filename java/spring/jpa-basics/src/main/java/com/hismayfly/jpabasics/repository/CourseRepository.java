package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    public Course findByTitle(String title);
}
