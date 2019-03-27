package com.dream.ems.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dream.ems.po.CourseTable;
import com.dream.ems.po.CourseTableStudent;
public interface CourseTableStudentRepository extends JpaRepository<CourseTableStudent, Integer>{

	@Query("select count(*) from CourseTableStudent cts where cts.coursetableId=?1")
	Integer countStusByCtId(Integer id);
	@Query("select ct from CourseTable ct where ct.college.id=?1 and ct.major.id=?2")
	List<CourseTable> findAllByCollegeIdAndMajorId(String collegeId, String majorId);
	
	@Query("select cts from CourseTableStudent cts where cts.studentStuNo=?1")
	List<CourseTableStudent> findAllByStudentStuNo(String stuNo);
	
	@Query ("from CourseTableStudent c where c.coursetableId = ?1")
	List<CourseTableStudent> findByCourseTableId(String id);

}
