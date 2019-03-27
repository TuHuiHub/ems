package com.dream.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, String> {

	Page<Teacher> findAllByNameLike(String string, Pageable pageInput);

	Teacher findByUser(String userId);
    @Query("select t from Teacher t where t.user.id=?1")
	Teacher findByUserId(String userId);
	void deleteByJobNoIn(String[] id);

	@Query("select t from Teacher t where t.college.id=?1")
	List<Teacher> findAllByCollegeId(String collegeId);

	@Query("select t.jobNo from Teacher t where t.college.id = ?1")
	List<String> findAllJobNoByCollegeId(String collegeId);
}
