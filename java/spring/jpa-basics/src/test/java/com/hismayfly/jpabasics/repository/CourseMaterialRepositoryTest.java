package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Course;
import com.hismayfly.jpabasics.domain.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
//@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseMaterialRepositoryTest {

    @Autowired
    public CourseMaterialRepository courseMaterialRepository;

    @Test
    public void printSaveNewCourseMaterial() {
        Course course = Course.builder()
                .title("English")
                .credit(10)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("english.com")
                .course(course)
                .build();
        courseMaterialRepository.save(courseMaterial);

        CourseMaterial retrieved = courseMaterialRepository.findByUrl("english.com");
        System.out.println("retrieved = " + retrieved);
    }
}