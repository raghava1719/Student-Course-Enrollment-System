package com.tgs.Student_Course_Enrollment_System.service.Implemetation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Student saveStudent(Student student){
        return sr.save(student);
    }
    @Override
	public List<Student> getAllStudents(){
        return sr.findAll();
    }
    @Override
	public Student getStudentById(long id){
        return sr.findById(id).orElse(null);
    }
    @Override
	public void deleteStudent(long id){
        sr.deleteById(id);
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

            throw new Exception("Stuent or Course doesn't exist");
        }

    }
}
