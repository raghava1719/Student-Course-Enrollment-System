package com.tgs.Student_Course_Enrollment_System.service.Implemetation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.tgs.Student_Course_Enrollment_System.entity.Course;
import com.tgs.Student_Course_Enrollment_System.entity.Student;
import com.tgs.Student_Course_Enrollment_System.repository.courseRepository;
import com.tgs.Student_Course_Enrollment_System.repository.studentRepository;
import com.tgs.Student_Course_Enrollment_System.service.studentService;

@Service
public class studentServiceImp implements studentService {

    @Autowired
    private studentRepository sr;
    @Autowired
    private courseRepository cr;

    @Override
    public Student saveStudent(Student student) throws Exception{
    	try {
    		return sr.save(student);			
		} catch (DataIntegrityViolationException e) 
    	{
			throw new Exception("Duplicate entry for phone no");
		}
    }
    @Override
	public List<Student> getAllStudents(){
        return sr.findAll();
    }
    @Override
	public Optional<Student> getStudentById(long id) {
        return sr.findById(id);
        
    }
    @Override
	public void deleteStudent(long id) throws Exception{
    	
    	if(sr.findById(id).isPresent()){
    		sr.deleteById(id);
    		return;}
    	throw new Exception("Student with ID " + id + " not found");
        
    }
    @Override
    public Student enrollStudentToCourse(long studentId,long courseId) throws Exception{
        Student student  = sr.findById(studentId).orElse(null);
        Course course =  cr.findById(courseId).orElse(null);

        if(student!=null && course !=null)
        {
        	student.getEnrolledCourses().add(course);
            sr.save(student);
            return student;
        }
        else{

            throw new Exception("Student or Course doesn't exist");
        }

    }
    
    @Override
    public Student UnEnrollStudentToCourse(long studentId, long courseId) throws Exception {
    	Student student  = sr.findById(studentId).orElse(null);
        Course course =  cr.findById(courseId).orElse(null);

        if(student!=null && course !=null)
        {
        	if(!student.getEnrolledCourses().contains(course))
        		throw new Exception("Student is NOT ENROLLED in this Course");
        	student.getEnrolledCourses().remove(course);
            sr.save(student);
            return student;
        }
        else{
        	if(student==null)
        		throw new Exception("Student doesn't exist");
            throw new Exception("Course doesn't exist");
        }

    }
	@Override
	public Student updateStudent(long id, Student newStudent) throws Exception {
		Student student  = sr.findById(id).orElse(null);
		if (student==null) 
			throw new Exception("Studnet with ID: "+id+" doesn't exist.");
		
		student.setName(newStudent.getName());
		student.setDepartment(newStudent.getDepartment());
		student.setPhno(newStudent.getPhno());
		try {
			sr.save(student);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Duplicate entry for phone no");
		}
		return student;
	}
	
	public List<Student> getStudentByDepartment(String department){
		
		return sr.findByDepartment(department);
	}
}
