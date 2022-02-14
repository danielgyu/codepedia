package com.hismayfly.jpabasics.repository;

import com.hismayfly.jpabasics.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    Student findByLastName(String firstName);
    List<Student> findByFirstName(String firstName);

    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Student getStudentByEmailAddress(String emailAddress);

    @Query("SELECT s.lastName FROM Student s WHERE s.email = ?1")
    String getStudentLastNameByEmailAddress(String emailAddress);

    @Query(
            value = "SELECT * FROM student WHERE email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String email);

    @Query(
            value = "SELECT * FROM student WHERE email_address = :email",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("email") String email);
}
