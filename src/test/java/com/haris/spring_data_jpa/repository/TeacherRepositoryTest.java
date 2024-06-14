package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Course;
import com.haris.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;
    @Test
    public void saveTeacher(){
        Course courseDBA = Course.builder()
                .title("DBA")
                .credit(5)
                .build();
        Course courseJava = Course.builder()
                .title("Java")
                .credit(9)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Kutub")
                .lastName("Khan")
                //.courses(List.of(courseDBA,courseJava))
                .build();

        teacherRepository.save(teacher);
    }
}