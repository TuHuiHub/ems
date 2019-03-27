package com.dream.ems.repository;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dream.ems.po.ClassRoom;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 实体ClassRoom基于spring-data的DAO接口.
 * @author cailei
 */
public interface ClassRoomRepository extends JpaRepository<ClassRoom, java.lang.String>{

	Page<ClassRoom> findAllByroomNameLike(java.lang.String searchContent, Pageable pageInput);

	int deleteByIdIn(String[] id);

	@Query("select ct.classRoom.id from CourseTable ct where ct.weekDay = ?1 and ct.lesson = ?2")
    List<Integer> findAllByWeekDayAndLesson(String week, String lesson);

	@Query("from ClassRoom c where c.id not in ?1 order by c.roomName")
	List<ClassRoom> findAllByIdNotIn(List<Integer> ints);

}
