package com.haris.spring_data_jpa.repository;

import com.haris.spring_data_jpa.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
   List<Student> findByFirstName(String firstName);
   List<Student> findByFirstNameContaining(String name);
   @Query("select s from Student s where s.emailId= ?1") //JPQL
   Student getStudentByEmailAddress(String email);
   @Query("select s.firstName from Student s where s.emailId= ?1") //JPQL
   String getStudentFirstNameByEmailAddress(String email);
   @Query(value = "select * from tbl_student s where s.email_address=?1",nativeQuery = true) //Native Query
   Student getStudentByEmailAddressNative(String email);

   @Query(value = "select * from tbl_student s where s.email_address= :email",nativeQuery = true) //Native Param
   Student getStudentByEmailAddressNativeParam(@Param("email") String email);
   @Modifying
   @Transactional
   @Query(value = "update tbl_student s set s.first_name = ?1 where s.email_address= ?2",nativeQuery = true)
   int updateStudentFirstNameByEmailAddress(String firstName, String email);
}
