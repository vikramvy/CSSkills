package com.web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLConnection {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStmt = null;
	private ResultSet resultSet = null;
	
	
	public void readDb() throws Exception{
		try {
			//autoReconnect=true&useSSL=false
			Class.forName("com.mysql.jdbc.Driver");
			String connectionUrl = "jdbc:mysql://localhost/world?autoReconnect=true&useSSL=false";
			connect = DriverManager.getConnection(connectionUrl, "root", "admin");
			statement = connect.createStatement();
			
			resultSet = statement.executeQuery("select * from world.city");
			//writeResultSet(resultSet);
			String selectSQL = "SELECT * FROM world.city WHERE name = ?";
			preparedStmt = connect.prepareStatement(selectSQL);
			preparedStmt.setString(1, "Himki");
			resultSet = preparedStmt.executeQuery();
			writeResultSet(resultSet);
			
		}catch(Exception e)
		{
			throw e;
		}finally {
			close();
		}
	}
	
	private void writeMetaData(ResultSet resultSet) throws SQLException {
        //  Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for  (int i = 1; i<= resultSet.getMetaData().getColumnCount(); i++){
            System.out.println("Column " +i  + " "+ resultSet.getMetaData().getColumnName(i));
        }
    }
	
	private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set
        while (resultSet.next()) {
            // It is possible to get the columns via name
            // also possible to get the columns via the column number
            // which starts at 1
            // e.g. resultSet.getSTring(2);
            String cityName = resultSet.getString("name");
            int population = resultSet.getInt("population");
          /*  String website = resultSet.getString("webpage");
            String summary = resultSet.getString("summary");
            Date date = resultSet.getDate("datum");
            String comment = resultSet.getString("comments");*/
            System.out.println("City: " + cityName+"| population: " + population);
           
        }
    }
	private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }
	public static void main(String[] args) {
		 MySQLConnection dao = new MySQLConnection();
	        try {
				dao.readDb();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
}
