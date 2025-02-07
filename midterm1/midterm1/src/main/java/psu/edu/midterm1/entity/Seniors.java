package psu.edu.midterm1.entity;

import jakarta.persistence.*;

@Entity
@Table(name="seniors")
public class Seniors {

	//define fields
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="course_title")
	private String courseTitle;

	@Column(name="course_name")
	private String courseName;

	@Column(name="course_instructor")
	private String courseInstructor;


	//define a constructor
	public Seniors() {

	}

	public Seniors(String courseTitle, String courseName, String courseIntructor) {
		this.courseTitle = courseTitle;
		this.courseName = courseName;
		this.courseInstructor = courseIntructor;
	}

	//define getters/setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourseTitle() {
		return courseTitle;
	}

	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCourseInstructor() {
		return courseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		this.courseInstructor = courseInstructor;
	}


	
	//define toString() method

	@Override
	public String toString() {
		return "Seniors [id=" + id + ", courseTitle=" + courseTitle + ", courseName=" + courseName
				+ ", courseInstructor=" + courseInstructor + "]";
	}
}
