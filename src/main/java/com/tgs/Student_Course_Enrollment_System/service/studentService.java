package com.tgs.Student_Course_Enrollment_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Student;


public interface studentService {

    Student saveStudent(Student student);
	List<Student> getAllStudents();
	Student getStudentById(long id);
	void deleteStudent(long id);
    Student enrollStudentToCourse(long studentId,long courseId) throws Exception;

}
