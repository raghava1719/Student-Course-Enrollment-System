package com.tgs.Student_Course_Enrollment_System.controller;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.service.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/api/course")
public class courseController {

    @Autowired
    private courseService courseService;

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.saveCourse(course);
    }

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }
    @GetMapping("/{id}")
    public Optional<Course> getCourseById(@PathVariable long id) {
        return courseService.getCourseById(id);
    }
    @GetMapping("/{id}/student")
    public Set<Student> getAllStudentsByCourse(@PathVariable long id) {
        return courseService.getAllStudentsByCourse(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        courseService.deleteCourse(id);
    }
}
