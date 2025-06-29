package com.tgs.Student_Course_Enrollment_System.service.Implemetation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.repository.courseRepository;
import com.tgs.Student_Course_Enrollment_System.service.courseService;

@Service
public class courseServiceImp implements courseService {

   
    @Autowired
    private courseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) {
           return courseRepository.save(course);
    }
    @Override
	public List<Course> getAllCourses(){
        return  courseRepository.findAll();
    }
    @Override
	public Optional<Course> getCourseById(int id)
    {
        return courseRepository.findById((long)id);
    }
    @Override
	public void deleteCourse(int id){
        courseRepository.deleteById((long)id);
    }

}
