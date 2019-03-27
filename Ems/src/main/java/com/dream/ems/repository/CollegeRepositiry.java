package com.dream.ems.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.College;

public interface CollegeRepositiry extends JpaRepository<College, String> {

	Page<College> findAllByNameLike(String string, Pageable pageInput);

	void deleteByIdIn(String[] id);

}
