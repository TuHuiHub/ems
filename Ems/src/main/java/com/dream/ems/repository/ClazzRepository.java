package com.dream.ems.repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.Clazz;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 实体Clazz基于spring-data的DAO接口.
 * @author cailei
 */
public interface ClazzRepository extends JpaRepository<Clazz, java.lang.String>{

	Page<Clazz> findAllByclazzNameLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);

    List<Clazz> findAllByMajorId(String majorId);

    @Query("SELECT ct.clazz.id FROM CourseTable ct where ct.course.id = ?1 GROUP BY ct.clazz.id HAVING count(ct.id) >= ?2")
	List<Integer> findAllNotFreeClazz(String id, Long time);

    @Query("from Clazz c where c.major.id = ?1 and c.id not in ?2")
	List<Clazz> findAllFreeClazz(String majorId, List<Integer> ints);
}
