package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Course;
import com.haris.spring_data_jpa.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {
    @Autowired
    private CourseMaterialRepository courseMaterialRepository;
    @Test
    public void saveCourseMaterial(){
        Course course = Course.builder()
                .title(".net")
                .credit(8)
                .build();
        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.microsoft.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }
    
    @Test
    public void printAllCourseMaterials(){
        List<CourseMaterial> courseMaterialList = courseMaterialRepository.findAll();
        System.out.println("courseMaterialList = " + courseMaterialList);
    }
}
