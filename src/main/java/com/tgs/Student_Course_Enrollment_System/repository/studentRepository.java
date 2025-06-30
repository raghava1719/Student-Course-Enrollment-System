package com.tgs.Student_Course_Enrollment_System.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tgs.Student_Course_Enrollment_System.entity.Student;

@Repository
public interface studentRepository extends  JpaRepository<Student,Long> {

	List<Student> findByDepartment(String dept);
}
