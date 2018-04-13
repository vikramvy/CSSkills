package com.java.cassandra.javacassclient;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Cluster.Builder;
import com.datastax.driver.core.Session;

public class CassandraConenctor {

	private Cluster cluster;
	private Session session;
	
	public Session getSession() {
		return session;
	}

	public void Connect(String node, Integer port)
	{
		Builder b = Cluster.builder().addContactPoint(node);
		if(port !=null)
		{
			b.withPort(port);
		}
		cluster = b.build();
		session = cluster.connect();
	}
	public void close()
	{
		session.close();
		cluster.close();
	}
}



