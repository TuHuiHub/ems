package com.dream.ems.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.TeacherCourse;
public interface TeacherCourseRepository extends JpaRepository<TeacherCourse, String> {

	@Query("select tc from TeacherCourse tc where tc.course.id = ?1 and tc.teacher.jobNo = ?2")
	TeacherCourse findByCIdAndTId(String coursId, String teacherJobNo);

	@Query ("from TeacherCourse t where t.teacher.jobNo = ?1")
	List<TeacherCourse> findAllByTeacherId(String jobNo);

}
