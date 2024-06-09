package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   List<Student> findByFirstName(String firstName);
   List<Student> findByFirstNameContaining(String name);
   @Query("select s from Student s where s.emailId= ?1") //JPQL
   Student getStudentByEmailAddress(String email);
   @Query("select s.firstName from Student s where s.emailId= ?1") //JPQL
   String getStudentFirstNameByEmailAddress(String email);
}
