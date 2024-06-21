package com.coherentsolutions.spring.school.section23crud;

import com.github.javafaker.Faker;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        Faker faker = new Faker();
        StudentService studentService = context.getBean(StudentService.class);

        Student student = new Student();
        student.setFirstName(faker.name().firstName());
        student.setLastName(faker.name().lastName());
        student.setEmail(faker.internet().emailAddress());

        System.out.println(student.getId());

        // Create student
        studentService.createStudent(student);
        System.out.println(student.getId());

        System.out.println(String.format("Student %s %s with email %s and id = %s is created", student.getFirstName(), student.getLastName(), student.getEmail(), student.getId()));

        // Read student
        Student retrievedStudent = studentService.getStudentById(student.getId());
        System.out.println("Retrieved Student: " + retrievedStudent.getFirstName() + " " + retrievedStudent.getLastName());

        // Update student email
        retrievedStudent.setEmail(faker.internet().emailAddress());
        studentService.updateStudent(retrievedStudent);

        // Find by last name
        List<Student> students = studentService.getStudentsByLastName("Barrows");
        students.forEach(s -> System.out.println("Student: " + s.getFirstName() + " " + s.getLastName()));

        // Find by email
        Student studentByEmail = studentService.getStudentByEmail("john.newemail@example.com");
        System.out.println("Student by Email: " + studentByEmail.getFirstName() + " " + studentByEmail.getLastName());

        // Delete student
        //studentService.deleteStudent(retrievedStudent.getId());
    }
}
