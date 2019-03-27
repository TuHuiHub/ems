package com.dream.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.Major;

public interface MajorRepository extends JpaRepository<Major, String> {

	@Query(value="select m from Major m where m.college.id = ?1")
	List<Major> findAllByCollege_id(String CollegeId);

	void deleteByIdIn(String[] id);

	Page<Major> findAllByNameLike(String string, Pageable pageInput);

}
