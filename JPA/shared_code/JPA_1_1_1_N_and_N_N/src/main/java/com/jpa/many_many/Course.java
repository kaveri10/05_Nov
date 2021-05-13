package com.jpa.many_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="course")
public class Course {

	@Id
	@GeneratedValue
	@Column(name="course_id")
	private int courseId;
	
	@Column(name="name")
	private String courseName;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_course", 
				joinColumns = { @JoinColumn(name = "course_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private Set<Student> students = new HashSet<Student>();

	public Course() {}
	
	public Course(String courseName) {
		this.courseName = courseName;
	}

	public Course(String courseName, Set<Student> students) {
		this.courseName = courseName;
		this.students = students;
	}

	public int getCourseId() {
		return this.courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	@Column(name="COURSE_NAME", nullable=false)
	public String getCourseName() {
		return this.courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

}