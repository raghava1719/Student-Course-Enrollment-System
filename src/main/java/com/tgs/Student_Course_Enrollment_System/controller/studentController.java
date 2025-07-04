package com.tgs.Student_Course_Enrollment_System.controller;

import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class studentController {

    @Autowired
    private studentService studentService;

    @PostMapping
    public ResponseEntity<?> createCourse(@RequestBody Student  student) {
        try {
        	return ResponseEntity.ok().body(studentService.saveStudent(student));
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable long id)  {
    	
    		Optional<Student> studnet = studentService.getStudentById(id);
    		if(studnet.isPresent())
    			return ResponseEntity.ok(studnet.get());
    		else {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found");
			}
    }
    @GetMapping("/")
    public ResponseEntity<?> getStudentByDepartment(@RequestParam String department)  {
    		List<Student> student = studentService.getStudentByDepartment(department);
    		System.out.println(student);
    		if(student.size()!=0)
    			return ResponseEntity.ok(student);
    		else {
    			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Students with Department name: " + department + " not found");
			}
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?>  deleteStudent(@PathVariable int id) {
        try {
			studentService.deleteStudent(id);
			return ResponseEntity.ok().body("Student with ID " + id + " deleted");
		} catch (Exception e) {
		
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    }
    @PutMapping("/{studentId}/course/{courseId}")
     public ResponseEntity<?> enrollStudentToCourse(@PathVariable
     long studentId,@PathVariable long courseId) throws Exception{
    	try {
    		return ResponseEntity.ok().body(studentService.enrollStudentToCourse(studentId, courseId));
		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
     }
    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable long id,@RequestBody Student newStudent) {
		
    	try {
    		return ResponseEntity.ok().body(studentService.updateStudent(id, newStudent));
		} catch (Exception e) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
    	
	}
    
    @DeleteMapping("/{studentId}/course/{courseId}")
    public ResponseEntity<?> UnEnrollStudentToCourse(@PathVariable
    long studentId,@PathVariable long courseId) throws Exception{

       try {
   		return ResponseEntity.ok().body(studentService.UnEnrollStudentToCourse(studentId, courseId));
   		} catch (Exception e) {
			
			return ResponseEntity.badRequest().body(e.getMessage());
		}
    }
}
