package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Guardian;
import com.haris.spring_data_jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    void saveStudent(){
        Student student = Student.builder()
                .firstName("Haris")
                .lastName("Pathan")
                .emailId("haris@yopmail.com")
//                .guardianName("Zakir")
//                .guardianEmail("zakir@yopmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }
    @Test
    void saveStudentWithGuardian(){
        Guardian guardian = Guardian.builder()
                .name("Talha")
                .email("talha@yopmail.com")
                .mobile("1234567890")
                .build();
        Student student = Student.builder()
                .firstName("Shahin")
                .lastName("Pathan")
                .emailId("shahin@yopmail.com")
                .guardian(guardian)
                .build();
        studentRepository.save(student);
    }
    @Test
    void getAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    void getStudentsByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("haris");
        System.out.println("studentList = " + studentList);
    }
    @Test
    void getStudentsByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("ha");
        System.out.println("studentList = " + studentList);
    }
    @Test
    void getStudentByEmailAddress(){
        Student student = studentRepository.getStudentByEmailAddress("haris@yopmail.com");
        System.out.println("student = " + student);
    }
    @Test
    void getStudentFirstNameByEmailAddress(){
        String student = studentRepository.getStudentFirstNameByEmailAddress("haris@yopmail.com");
        System.out.println("student = " + student);
    }
}
