package com.tgs.Student_Course_Enrollment_System.entity;

import java.util.Set;
import java.util.stream.Collectors;



public class CourseDTO {
	
    private Long id;
    private String name;
    private Set<StudentDTO> students;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.students = course.getStudentsSet().stream()
                .map(StudentDTO::new)
                .collect(Collectors.toSet());
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<StudentDTO> getStudents() {
		return students;
	}

	public void setStudents(Set<StudentDTO> students) {
		this.students = students;
	}

    // Getters & Setters (or use Lombok)
}
