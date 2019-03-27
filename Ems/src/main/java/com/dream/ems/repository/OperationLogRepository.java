package com.dream.ems.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.OperationLog;

public interface OperationLogRepository extends JpaRepository<OperationLog, Integer> {


	Page<OperationLog> findAllByMethodLike(String string, Pageable pageInput);

}
