package com.tgs.Student_Course_Enrollment_System.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class StudentDTO {

    private Long id;
    private String name;
    

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
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
}
