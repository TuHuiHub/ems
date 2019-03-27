package com.dream.ems.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.StudentCourse;

public interface StudentCourseRepository extends JpaRepository<StudentCourse, String>{
	
	@Query ("from StudentCourse s where s.course.id = ?1")
	List<StudentCourse> findBycourseId(String id);
	
	@Query("from StudentCourse s where s.student.stuNo = ?1")
	List<StudentCourse> findAllByStudentStuNo(String stuNo);
}
