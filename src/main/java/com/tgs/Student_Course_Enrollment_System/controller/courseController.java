package com.tgs.Student_Course_Enrollment_System.controller;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.CourseDTO;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.entity.StudentDTO;
import com.tgs.Student_Course_Enrollment_System.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/course")
public class courseController {

    @Autowired
    private courseService courseService;

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Course course) {
        try {
        	return ResponseEntity.ok().body(courseService.saveCourse(course));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable long id) {
    	
    	Course course = courseService.getCourseById(id).orElse(null);
        if(course==null)
        	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Course with ID: "+id+" doesn't exist.");
        return ResponseEntity.ok(new CourseDTO(course));

    }
    @GetMapping("/{id}/student")
    public Stream<StudentDTO> getAllStudentsByCourse(@PathVariable long id) {
        return courseService.getAllStudentsByCourse(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable long id,@RequestBody Student newCourse) {
		
    	try {
    		return ResponseEntity.ok().body(courseService.updateCourse(id, newCourse));
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    	
	}
    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable long id) {
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
