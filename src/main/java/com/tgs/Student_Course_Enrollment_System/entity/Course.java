package com.tgs.Student_Course_Enrollment_System.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    
    @JsonIgnore
    @ManyToMany(mappedBy = "enrolledCourses")
    private Set<Student> studentsSet = new HashSet<Student>();


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<Student> getStudentsSet() {
		return studentsSet;
	}


	public void setStudentsSet(Set<Student> studentsSet) {
		this.studentsSet = studentsSet;
	}

}

