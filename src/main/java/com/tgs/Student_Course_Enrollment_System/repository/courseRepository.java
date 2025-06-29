package com.tgs.Student_Course_Enrollment_System.repository;

import com.tgs.Student_Course_Enrollment_System.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface courseRepository extends JpaRepository<Course,Long>{

}
