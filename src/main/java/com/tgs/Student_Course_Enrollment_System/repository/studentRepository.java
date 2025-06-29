package com.tgs.Student_Course_Enrollment_System.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgs.Student_Course_Enrollment_System.entity.Student;

public interface studentRepository extends  JpaRepository<Student,Long> {

}
