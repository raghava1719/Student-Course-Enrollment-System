package com.tgs.Student_Course_Enrollment_System.service.Implemetation;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
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
	public Optional<Course> getCourseById(long id)
    {
        return courseRepository.findById(id);
    }
    @Override
	public void deleteCourse(long id){
        courseRepository.deleteById(id);
    }
    @Override
    public Set<Student> getAllStudentsByCourse(long id){
    	
    	
    	Optional<Course> course= courseRepository.findById(id);
    	
    		return course.get().getStudentsSet();
    	
    }

}
