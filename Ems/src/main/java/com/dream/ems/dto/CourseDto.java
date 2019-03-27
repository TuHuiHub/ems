package com.dream.ems.dto;

import java.util.ArrayList;
import java.util.List;


import com.dream.ems.po.Course;
import com.dream.ems.po.Major;
import com.dream.ems.po.StudentCourse;
import com.dream.ems.po.TeacherCourse;

import wo.bsys.po.Dictionary;
import wo.common.entity.WoPage;
import wo.common.util.WoUtil;

public class CourseDto {


    private String id;

    private String name;

    private String courseWeek;        //学时

    private String courseScore;        //学分

    private Boolean isOptional;     //是否选修

    private String majorId;

    private String majorName;

    private List<TeacherCourseDto> teacherCourse = new ArrayList<>();

    private List<StudentCourseDto> studentCourse = new ArrayList<>();

    private String semesterId;

    private String semesterName;

    private String startWeek;

    private String endWeek;

    public CourseDto() {

    }

    public CourseDto(String id, String name, String courseWeek, String courseScore, Boolean isOptional, String majorId, String majorName, List<TeacherCourseDto> teacherCourse, List<StudentCourseDto> studentCourse, String semesterId, String semesterName, String startWeek, String endWeek) {
        this.id = id;
        this.name = name;
        this.courseWeek = courseWeek;
        this.courseScore = courseScore;
        this.isOptional = isOptional;
        this.majorId = majorId;
        this.majorName = majorName;
        this.teacherCourse = teacherCourse;
        this.studentCourse = studentCourse;
        this.semesterId = semesterId;
        this.semesterName = semesterName;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
    }

    public CourseDto(Course po) {
        this.id = po.getId();
        this.name = po.getName();
        this.courseWeek = po.getCourseWeek();
        this.courseScore = po.getCourseScore();
        this.isOptional = po.getIsOptional();
        if (!WoUtil.isEmpty(po.getMajor())) {
            this.majorId = po.getMajor().getId();
            this.majorName = po.getMajor().getName();
        }
        if (!WoUtil.isEmpty(po.getSemester())) {
            this.semesterId = po.getSemester().getId();
            this.semesterName = po.getSemester().getName();
        }
        this.teacherCourse = CourseDto.getDtosTC(po.getTeacherCourse());
        this.studentCourse = CourseDto.getDtosSC(po.getStudentCourse());
        this.startWeek = po.getStartWeek();
        this.endWeek = po.getEndWeek();
    }


    public static List<TeacherCourseDto> getDtosTC(List<TeacherCourse> pos) {
        List<TeacherCourseDto> rs = new ArrayList<TeacherCourseDto>();
        for (TeacherCourse r : pos) {
            TeacherCourseDto dto = new TeacherCourseDto(r);
            rs.add(dto);
        }
        return rs;
    }

    public static List<StudentCourseDto> getDtosSC(List<StudentCourse> pos) {
        List<StudentCourseDto> rs = new ArrayList<StudentCourseDto>();
        for (StudentCourse r : pos) {
            StudentCourseDto dto = new StudentCourseDto(r);
            rs.add(dto);
        }
        return rs;
    }

    public static WoPage<CourseDto> getPageData(List<Course> content, Long totalElements) {
        List<CourseDto> dtos = new ArrayList<CourseDto>();
        for (Course po : content) {
            dtos.add(new CourseDto(po));
        }
        return new WoPage<CourseDto>(dtos, totalElements);
    }


    public Boolean getIsOptional() {
        return isOptional;
    }

    public void setIsOptional(Boolean isOptional) {
        this.isOptional = isOptional;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourseWeek() {
        return courseWeek;
    }

    public void setCourseWeek(String courseWeek) {
        this.courseWeek = courseWeek;
    }

    public String getCourseScore() {
        return courseScore;
    }

    public void setCourseScore(String courseScore) {
        this.courseScore = courseScore;
    }

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public Boolean getOptional() {
        return isOptional;
    }

    public void setOptional(Boolean optional) {
        isOptional = optional;
    }

    public String getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(String semesterId) {
        this.semesterId = semesterId;
    }

    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    public String getStartWeek() {
        return startWeek;
    }

    public void setStartWeek(String startWeek) {
        this.startWeek = startWeek;
    }

    public String getEndWeek() {
        return endWeek;
    }

    public void setEndWeek(String endWeek) {
        this.endWeek = endWeek;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<TeacherCourseDto> getTeacherCourse() {
        return teacherCourse;
    }

    public void setTeacherCourse(List<TeacherCourseDto> teacherCourse) {
        this.teacherCourse = teacherCourse;
    }

    public List<StudentCourseDto> getStudentCourse() {
        return studentCourse;
    }

    public void setStudentCourse(List<StudentCourseDto> studentCourse) {
        this.studentCourse = studentCourse;
    }

    @Override
    public String toString() {
        return "CourseDto [id=" + id + ", name=" + name + ", courseWeek=" + courseWeek + ", courseScore=" + courseScore
                + ", isOptional=" + isOptional + ", majorId=" + majorId + ", majorName=" + majorName
                + ", teacherCourse=" + teacherCourse + ", studentCourse=" + studentCourse + "]";
    }

    public static List<CourseDto> getDtos(List<Course> content) {
        List<CourseDto> dtos = new ArrayList<CourseDto>();
        for (Course po : content) {
            dtos.add(new CourseDto(po));
        }
        return dtos;
    }

    public Course createPO() {
        Course po = new Course();
        po.setId(id);
        po.setName(name);
        po.setCourseScore(courseScore);
        po.setCourseWeek(courseWeek);
        if (!WoUtil.isEmpty(majorId)) {
            po.setIsOptional(false);
        } else {
            po.setIsOptional(true);
        }
        if (!WoUtil.isEmpty(majorId)) {
            Major major = new Major();
            major.setId(majorId);
            po.setMajor(major);
        }
        if (!WoUtil.isEmpty(semesterId)) {
            Dictionary dictionary = new Dictionary();
            dictionary.setId(semesterId);
            po.setSemester(dictionary);
        }
        po.setStartWeek(startWeek);
        po.setEndWeek(endWeek);
        return po;
    }

    public void update(Course po) {
        po.setId(id);
        po.setName(name);
        po.setCourseScore(courseScore);
        po.setCourseWeek(courseWeek);
        if (!WoUtil.isEmpty(majorId)) {
            po.setIsOptional(false);
        } else {
            po.setIsOptional(true);
        }
        if (!WoUtil.isEmpty(majorId)) {
            Major major = new Major();
            major.setId(majorId);
            po.setMajor(major);
        } else {
            po.setMajor(null);
        }
        if (!WoUtil.isEmpty(semesterId)) {
            Dictionary dictionary = new Dictionary();
            dictionary.setId(semesterId);
            po.setSemester(dictionary);
        } else {
            po.setSemester(null);
        }
        po.setStartWeek(startWeek);
        po.setEndWeek(endWeek);
    }
}
