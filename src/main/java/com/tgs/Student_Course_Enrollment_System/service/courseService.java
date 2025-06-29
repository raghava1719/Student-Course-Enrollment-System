package com.tgs.Student_Course_Enrollment_System.service;

import java.util.List;
import java.util.Optional;

import com.tgs.Student_Course_Enrollment_System.entity.Course;

public interface courseService {

	Course saveCourse(Course course);
	List<Course> getAllCourses();
	Optional<Course> getCourseById(int id);
	void deleteCourse(int id);

}
