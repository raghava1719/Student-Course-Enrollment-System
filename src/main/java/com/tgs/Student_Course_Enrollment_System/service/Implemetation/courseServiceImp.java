package com.tgs.Student_Course_Enrollment_System.service.Implemetation;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.entity.StudentDTO;
import com.tgs.Student_Course_Enrollment_System.repository.courseRepository;
import com.tgs.Student_Course_Enrollment_System.service.courseService;

@Service
public class courseServiceImp implements courseService {

   
    @Autowired
    private courseRepository courseRepository;

    @Override
    public Course saveCourse(Course course) throws Exception {
    	try {
    		return courseRepository.save(course);			
		} catch (JpaSystemException e) 
    	{
			
			throw new Exception("Duplicate entry for Course Name");
		}
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
	public void deleteCourse(long id) throws Exception{
    	
    	Course course = courseRepository.findById(id).orElse(null);
    	if(course!=null) {
        if(course.getStudentsSet().size()!=0) {
        	throw new Exception("Cannot Delete Course Enrolled with Students");
    	}
    	courseRepository.deleteById(id);	}
    	else {
			throw new Exception("No Course Found");
		}
    }
    @Override
    public Stream<StudentDTO> getAllStudentsByCourse(long id){
    	
    	
    	Optional<Course> course= courseRepository.findById(id);
    	
    		return course.get().getStudentsSet().stream().map(StudentDTO::new);
    	
    }
	@Override
	public Course updateCourse(long id, Student newCourse) throws Exception {
		Course course  = courseRepository.findById(id).orElse(null);
		if (course==null) 
			throw new Exception("Course with ID: "+id+" doesn't exist.");
		
		course.setName(newCourse.getName());
		
		courseRepository.save(course);
		return course;
	}

}
