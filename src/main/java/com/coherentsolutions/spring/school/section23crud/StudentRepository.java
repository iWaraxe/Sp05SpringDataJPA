package com.coherentsolutions.spring.school.section23crud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByLastName(String lastName);

    @Query("SELECT s FROM Student s WHERE s.email = :email")
    Student findStudentByEmail(@Param("email") String email);
}
