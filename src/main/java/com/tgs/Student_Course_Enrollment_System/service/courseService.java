package com.tgs.Student_Course_Enrollment_System.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;

public interface courseService {

	Course saveCourse(Course course);
	List<Course> getAllCourses();
	Optional<Course> getCourseById(long id);
	void deleteCourse(long id);
	Set<Student> getAllStudentsByCourse(long id);

}
