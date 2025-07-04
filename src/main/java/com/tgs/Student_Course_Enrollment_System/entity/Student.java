package com.tgs.Student_Course_Enrollment_System.entity;

import java.math.BigInteger;
import java.util.*;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String department;	
	@Column(unique = true)
	private BigInteger phno;
	
	@ManyToMany
	@JoinTable(
			name = "student_courses",
			joinColumns = @JoinColumn(name = "student_id"),
			inverseJoinColumns = @JoinColumn(name = "course_id"))
	private Set<Course> enrolledCourses  = new HashSet<>();
	
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public BigInteger getPhno() {
		return phno;
	}

	public void setPhno(BigInteger phno) {
		this.phno = phno;
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

	public void setEnrolledCourses(Set<Course> enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}


	public Set<Course> getEnrolledCourses() {
		// TODO Auto-generated method stub
		return enrolledCourses;
	}

}
