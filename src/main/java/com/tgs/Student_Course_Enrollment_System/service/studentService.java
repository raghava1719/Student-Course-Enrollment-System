package com.tgs.Student_Course_Enrollment_System.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Student;


public interface studentService {

    Student saveStudent(Student student) throws Exception;
	List<Student> getAllStudents();
	Optional<Student> getStudentById(long id);
	void deleteStudent(long id) throws Exception;
    Student enrollStudentToCourse(long studentId,long courseId) throws Exception;
	Student UnEnrollStudentToCourse(long studentId, long courseId) throws Exception;
	Student updateStudent(long id, Student newStudent) throws Exception;

}
