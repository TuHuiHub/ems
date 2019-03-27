package com.dream.ems.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.TimeSlot;

/**
 * 实体TimeSlot基于spring-data的DAO接口.
 * @author cailei
 */
public interface TimeSlotRepository extends JpaRepository<TimeSlot, java.lang.String>{

	Page<TimeSlot> findAllByTimeLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);
}
