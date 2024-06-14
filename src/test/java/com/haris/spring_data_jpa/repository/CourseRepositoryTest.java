package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Course;
import com.haris.spring_data_jpa.entity.Student;
import com.haris.spring_data_jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;
    @Test
    public void printCourses(){
        List<Course> courseList = courseRepository.findAll();
        System.out.println("courseList = " + courseList);
    }
    @Test
    public void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Tamanna")
                .lastName("Patil")
                .build();
        Course course = Course.builder()
                .title("PE")
                .credit(4)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }
    @Test
    public void findAllPagination(){
        Pageable firstPage = PageRequest.of(0,2);
        Pageable secondPage =PageRequest.of(1,2);
        List<Course> courses = courseRepository.findAll(firstPage).getContent();
        
        long totalElements = courseRepository.findAll(firstPage).getTotalElements();
        
        long totalPages = courseRepository.findAll(firstPage).getTotalPages();

        System.out.println("totalPages = " + totalPages);

        System.out.println("totalElements = " + totalElements);

        System.out.println("courses = " + courses);
    }
    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCreditDescending = PageRequest.of(0,2, Sort.by("credit").descending());

        Pageable sortByTitleAndCredit = PageRequest.of(0,2,Sort.by("title").and(Sort.by("credit")));

        List<Course> courses = courseRepository.findAll(sortByTitleAndCredit).getContent();

        System.out.println("courses = " + courses);
    }
    @Test
    public void printFindByTitleContaining(){
        List<Course> courses = courseRepository.findByTitleContaining("D", PageRequest.of(0,10)).getContent();
        System.out.println("courses = " + courses);
    }
    @Test
    public void saveCourseWithTeacherAndStudent(){
        Teacher teacher = Teacher.builder()
                .firstName("Haris")
                .lastName("Pathan")
                .build();
        Course course = Course.builder()
                .title("Spring")
                .credit(10)
                .teacher(teacher)
                .build();
        Student student = Student.builder()
                .firstName("Dhruv")
                .lastName("Rathee")
                .emailId("dhruv@gmail.com")
                .build();
        course.addStudent(student);

        courseRepository.save(course);
    }
}
