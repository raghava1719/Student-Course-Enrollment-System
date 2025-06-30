package com.tgs.Student_Course_Enrollment_System.entity;

import java.math.BigInteger;

public class StudentDTO {

    private Long id;
    private String name;
    private String department; 
    private BigInteger phno;
    

    public StudentDTO(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.department = student.getDepartment();
        this.phno = student.getPhno();
        
    }

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
}
