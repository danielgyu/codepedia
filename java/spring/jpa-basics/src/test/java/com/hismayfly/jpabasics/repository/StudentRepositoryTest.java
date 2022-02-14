package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Guardian;
import com.hismayfly.jpabasics.domain.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//@SpringBootTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveOneStudent() {
        Student student = Student.builder()
                .firstName("first")
                .lastName("last")
                .email("test@abc.com")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents() {
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void findStudentsByFirstName() {
        Guardian guardian = new Guardian("g", "e", "m");
        Student student1 = Student.builder()
                .firstName("lee")
                .lastName("last1")
                .email("last1@ab.com")
                .guardian(guardian)
                .build();
        Student student2 = Student.builder()
                .firstName("lee")
                .lastName("last2")
                .email("last2@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student1);
        studentRepository.save(student2);

        List<Student> studentListByFirstName = studentRepository.findByFirstName("lee");
        System.out.println("studentListByFirstName = " + studentListByFirstName);
    }

    @Test
    public void findByLasttName() {
        Guardian guardian = new Guardian("g1", "e1", "m1");
        Student student1 = Student.builder()
                .firstName("lee")
                .lastName("last3")
                .email("last1@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student1);

        Student studentByLastName = studentRepository.findByLastName("last3");
        System.out.println("studentByLastName = " + studentByLastName);
    }

    @Test
    public void printStudentByEmailAddress() {
        Guardian guardian = new Guardian("g1", "e1", "m1");
        Student student = Student.builder()
                .firstName("lee")
                .lastName("last3")
                .email("last2@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

        Student studentByEmailAddress = studentRepository.getStudentByEmailAddress("last2@ab.com");
        System.out.println("studentByEmailAddress = " + studentByEmailAddress);
    }

    @Test
    public void printStudentLastNameByEmailAddress() {
        Guardian guardian = new Guardian("g1", "e1", "m1");
        Student student = Student.builder()
                .firstName("lee")
                .lastName("last3")
                .email("last2@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

        String lastName = studentRepository.getStudentLastNameByEmailAddress("last2@ab.com");
        System.out.println("lastName = " + lastName);
    }

    @Test
    public void printStudentByEmailAddressNative() {
        Guardian guardian = new Guardian("g1", "e1", "m1");
        Student student = Student.builder()
                .firstName("lee")
                .lastName("last3")
                .email("last2@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

        Student studentByEmailAddress = studentRepository.getStudentByEmailAddressNative("last2@ab.com");
        System.out.println("studentByEmailAddress = " + studentByEmailAddress);
    }

    @Test
    public void printStudentByEmailAddressNativeNamedParam() {
        Guardian guardian = new Guardian("g1", "e1", "m1");
        Student student = Student.builder()
                .firstName("lee")
                .lastName("last3")
                .email("last2@ab.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);

        Student studentByEmailAddress = studentRepository.getStudentByEmailAddressNativeNamedParam("last2@ab.com");
        System.out.println("studentByEmailAddress = " + studentByEmailAddress);
    }
}