package com.dream.ems.repository;

import com.dream.ems.po.Major;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.Course;

public interface CourseRepository extends JpaRepository<Course, String> {

	void deleteByIdIn(String[] id);

	Page<Course> findAllByNameLike(String string, Pageable pageInput);

	@Query("select c from Course c where c.major.id=?1")
	List<Course> findAllByMajorId(String majorId);

	@Query("select c from Course c where c.major.id=?1 and c.semester.id=?2")
	List<Course> findAllByMajorIdAndSemesterId(String majorId, String semesterId);

	Page<Course> findAllByMajorId(String majorId, Pageable pageInput);

	Page<Course> findAllByNameLikeAndMajorId(String string, String majorId, Pageable pageInput);
}