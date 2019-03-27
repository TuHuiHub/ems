package com.dream.ems.po;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_coursetable_student")
public class CourseTableStudent {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column
	private String studentStuNo;
	
	@Column
	private Integer coursetableId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStudentStuNo() {
		return studentStuNo;
	}

	public void setStudentStuNo(String studentStuNo) {
		this.studentStuNo = studentStuNo;
	}

	public Integer getCoursetableId() {
		return coursetableId;
	}

	public void setCoursetableId(Integer coursetableId) {
		this.coursetableId = coursetableId;
	}

	@Override
	public String toString() {
		return "CourseTableStudent{" +
				"id=" + id +
				", studentStuNo='" + studentStuNo + '\'' +
				", coursetableId=" + coursetableId +
				'}';
	}
}
