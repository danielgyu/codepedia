package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printAllCourses() {
        Course eng = Course.builder()
                .title("ENG")
                .credit(3)
                .build();
        Course math = Course.builder()
                .title("MATH")
                .credit(3)
                .build();
        courseRepository.save(eng);
        courseRepository.save(math);

        List<Course> courses = courseRepository.findAll();
        System.out.println("courses = " + courses);
    }
}