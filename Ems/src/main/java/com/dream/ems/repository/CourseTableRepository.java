package com.dream.ems.repository;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.CourseTable;
public interface CourseTableRepository extends JpaRepository<CourseTable, Integer> {

	List<CourseTable> findAllByMajorId(String majorId);

	@Query("select ct.id from CourseTable ct where ct.major.id = ?1")
	List<Integer> findIdByMajorId(String id);

	void deleteByIdIn(List<Integer> courseTableIds);

	void deleteByMajorId(String majorId);
	
	@Query ("from CourseTable ct where ct.teacher.jobNo = ?1 and ct.semester.id = ?2")
	List<CourseTable> findAllByCourseTableTeacherId(String tId, String sid);

	void deleteByIdIn(Integer[] ids);

	@Query("select ct from CourseTable ct, Course c where c.id = ct.course.id and ct.major.id = ?1 and ct.semester.id = ?2 and c.isOptional = 1")
	Page<CourseTable> findAllByIsOptional(String majorId, String semesterId, Pageable pageInput);

	@Query("select ct from CourseTable ct, Course c where c.id = ct.course.id and c.name like ?1 and ct.major.id = ?2 and ct.semester.id = ?3 and c.isOptional = 1")
	Page<CourseTable> findAllByIsOptionalAndNameLike(String string, String majorId, String semesterId, Pageable pageInput);

	@Query("select ct from CourseTable ct where ct.teacher.jobNo in ?1")
	List<CourseTable> findAllByTeacherJobNoIn(List<String> jobNoes);

	@Query("from CourseTable ct where ct.teacher.jobNo = ?1 and ct.weekDay = ?2 and ct.lesson = ?3")
	CourseTable teacherIsFree(String teacherJobNo, String weekDay, String lesson);

	@Query("from CourseTable ct where ct.classRoom.id = ?1 and ct.weekDay = ?2 and ct.lesson = ?3")
	CourseTable isClassRoomFree(String classRoomId, String weekDay, String lesson);

	@Query("SELECT count(ct.clazz.id) FROM CourseTable ct where ct.course.id = ?1 and ct.clazz.id = ?2")
	Long isClazzFree(String courseId, String clazzId);

	@Query("from CourseTable ct where ct.course.id = ?1 and ct.teacher.jobNo = ?2")
	List<CourseTable> findAllByCourseAndTeacher(String courseId, String teacherJobNo);

	@Query("from CourseTable ct where ct.clazz.id = ?1 and ct.semester.id = ?2")
	List<CourseTable> findAllByClazz(String id, String semesterId);

	@Query("from CourseTable ct where ct.id in ?1")
    List<CourseTable> findAllByCourseTableIdIn(List<Integer> ids);
}