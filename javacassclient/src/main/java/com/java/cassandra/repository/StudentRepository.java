package com.java.cassandra.repository;

import java.util.ArrayList;
import java.util.List;


import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.java.cassandra.domain.Student;

public class StudentRepository {
	private static final String TABLE_NAME="Student";
	private static final String TABLE_NAME_BY_TITLE = TABLE_NAME + "ByFirstName";
	private Session session;
	
	public StudentRepository(Session session)
	{
		this.session = session;
	}
	 public void useKeyspace(String keyspace) {
	        session.execute("USE " + keyspace);
	    }
	 public void insertStudent(String keyspaceName,Student student) {
		 	useKeyspace(keyspaceName);
		 	
	        StringBuilder sb = new StringBuilder("INSERT INTO ").append(TABLE_NAME).append("(id, firstName, lastName, fees, maincourse) ").append("VALUES (").append(student.getId()).append(", '").append(student.getFirstname()).append("', '").append(student.getLastname()).append("',").append(student.getFees()).append(", '")
	                .append(student.getMaincourse()).append("');");
	        System.out.println(sb.toString());
	        final String query = sb.toString();
	        session.execute(query);
	    }
	 public List<Student> selectAll() {
	        StringBuilder sb = new StringBuilder("SELECT * FROM ").append(TABLE_NAME);

	        final String query = sb.toString();
	        ResultSet rs = session.execute(query);

	        List<Student> students = new ArrayList<Student>();

	        for (Row r : rs) {
	        	Student student = new Student(r.getInt("id"), r.getString("firstName"), r.getString("LastName"), r.getDouble("fees"),r.getString("maincourse")) ;
	        			
	            students.add(student);
	        }
	        return students;
	    }
}
