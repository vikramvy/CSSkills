package com.java.cassandra.domain;

public class Student {
	
	private int id;
	private String firstname;
	private String lastname;
	private double fees;
	private String maincourse;
	
	public Student() {}
	public Student(int id, String firstName, String lastName, double fees, String maincourse)
	{
		this.id = id;
		this.firstname = firstName;
		this.fees = fees;
		this.lastname = lastName;
		this.maincourse = maincourse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public String getMaincourse() {
		return maincourse;
	}

	public void setMaincourse(String maincourse) {
		this.maincourse = maincourse;
	};
	
	

}
