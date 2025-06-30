package com.tgs.Student_Course_Enrollment_System.service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.entity.StudentDTO;

public interface courseService {

	Course saveCourse(Course course) throws Exception;
	List<Course> getAllCourses();
	Optional<Course> getCourseById(long id);
	void deleteCourse(long id) throws SQLIntegrityConstraintViolationException, Exception;
	Stream<StudentDTO> getAllStudentsByCourse(long id);
	Course updateCourse(long id, Student newCourse) throws Exception;

}
