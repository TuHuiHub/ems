package com.dream.ems.repository;

import com.dream.ems.po.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, String> {

	Page<Student> findAllByNameLike(String string, Pageable pageInput);

	void deleteByStuNoIn(String[] id);
	@Query("select s.stuNo from Student s where s.major.id = ?1")
	List<String> findAllByMajorId(String majorId);
	

	@Query("select s from Student s where s.major.id = ?1")
	List<Student> findAllStudentByMajorId(String majorId);

	@Query("select s from Student s where s.clazz.id = ?1")
    List<Student> findAllByClazz(String id);
}
