package com.java.cassandra.javacassclient;

import org.apache.log4j.Logger;

import com.datastax.driver.core.Session;
import com.java.cassandra.domain.Student;
import com.java.cassandra.repository.StudentRepository;

/**
 * Hello world!
 *
 */
public class App 
{
	private final static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args )
	{
		CassandraConenctor connector = new CassandraConenctor();
		connector.Connect("127.0.0.1", 9042);
		Session session = connector.getSession();
		StudentRepository sr = new StudentRepository(session);
		String keyspaceName = "university";
		Student student = new Student(1, "Jim", "tim", 600.00, "Programming");
		try{
			sr.insertStudent(keyspaceName,student);
			logger.info("Record inserted successfully");
		}catch(Exception e)
		{
			logger.error("Failed to Insert record in Cassandra");
			e.getMessage();
		}
			sr.selectAll().forEach(o -> logger.info("Name of Student: " + o.getFirstname() + " " + o.getLastname()));
			sr.selectAll().forEach(o -> System.out.println("Name of Student: " + o.getFirstname() + " " + o.getLastname()));
		 connector.close();
    }
}
