package com.dream.ems.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.Admin;

public interface AdminRepository extends JpaRepository<Admin, String> {

	Page<Admin> findAllByNameLike(String string, Pageable pageInput);

	int deleteByJobNoIn(String[] id);

}
