package org.noticeBoard.entities;


public class Student {
	
	private int studentId;

	private String name;
	

	private String email;
	
	public Student() {
		super();
	}
	
	

	public Student(int studentId, String name, String email) {
		super();
		this.studentId = studentId;
		this.name = name;
		this.email = email;
	}

	public Student( String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}



	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + ", email=" + email + "]";
	}
	
	
}
