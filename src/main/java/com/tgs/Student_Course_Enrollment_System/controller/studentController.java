package com.tgs.Student_Course_Enrollment_System.controller;

import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class studentController {

    @Autowired
    private studentService studentService;

    @PostMapping
    public Student createCourse(@RequestBody Student  student) {
        return studentService.saveStudent(student);
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable long id) {
        return studentService.getStudentById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);;
    }
    @PutMapping("/{studentId}/course/{courseId}")
     public Student enrollStudentToCourse(@PathVariable
     long studentId,@PathVariable long courseId) throws Exception{

        return studentService.enrollStudentToCourse(studentId, courseId);
     }
    @DeleteMapping("/{studentId}/course/{courseId}")
    public Student UnEnrollStudentToCourse(@PathVariable
    long studentId,@PathVariable long courseId) throws Exception{

       return studentService.UnEnrollStudentToCourse(studentId, courseId);
    }
}
