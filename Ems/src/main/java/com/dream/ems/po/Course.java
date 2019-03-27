package com.dream.ems.po;

import wo.bsys.po.Dictionary;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 课程
 *
 * @author Ylinx
 * @date 2018年12月3日
 */
@Entity
@Table(name = "t_course")
public class Course {


    @Id
    @Column(length = 20)
    private String id;

    @Column(length = 50)
    private String name;

    @Column(length = 20)
    private String courseWeek;        //学时

    @Column(length = 20)
    private String courseScore;        //学分

    @Column(length = 20)
    private Boolean isOptional;     //是否选修课

    private String startWeek;

    private String endWeek;

    @ManyToOne
    @JoinColumn(name = "major_id")
    private Major major;

    @OneToMany(mappedBy = "course")
    private List<TeacherCourse> teacherCourse;

    @OneToMany(mappedBy = "course")
    private List<StudentCourse> studentCourse;

    @ManyToOne
    @JoinColumn(name = "semester_id")
    private Dictionary semester;

    public Course() {
        super();
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

    public Course(String id, String name, String courseWeek, String courseScore, Boolean isOptional, String startWeek,
                  String endWeek, Major major, List<TeacherCourse> teacherCourse, List<StudentCourse> studentCourse) {
        super();
        this.id = id;
        this.name = name;
        this.courseWeek = courseWeek;
        this.courseScore = courseScore;
        this.isOptional = isOptional;
        this.startWeek = startWeek;
        this.endWeek = endWeek;
        this.major = major;
        this.teacherCourse = teacherCourse;
        this.studentCourse = studentCourse;
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


    public Major getMajor() {
        return major;
    }


    public void setMajor(Major major) {
        this.major = major;
    }

    //
    public List<TeacherCourse> getTeacherCourse() {
        return teacherCourse;
    }


    public void setTeacherCourse(List<TeacherCourse> teacherCourse) {
        this.teacherCourse = teacherCourse;
    }


    public List<StudentCourse> getStudentCourse() {
        return studentCourse;
    }


    public void setStudentCourse(List<StudentCourse> studentCourse) {
        this.studentCourse = studentCourse;
    }


    public Boolean getOptional() {
        return isOptional;
    }

    public void setOptional(Boolean optional) {
        isOptional = optional;
    }

    public Dictionary getSemester() {
        return semester;
    }

    public void setSemester(Dictionary semester) {
        this.semester = semester;
    }
}
