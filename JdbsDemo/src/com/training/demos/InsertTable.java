package com.training.demos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTable {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/trainingdb";
	String username="root";
	String password="Malini@25";
	
	String sql ="insert into  student values(?,?,?)";
	Connection connection = null;
	PreparedStatement statement =null;
	try {
		connection = DriverManager.getConnection(url,username,password);
		statement =connection.prepareStatement(sql);
		statement.setString(1, "rathipriya");
		statement.setInt(2, 3);
		statement.setString(3, "BME");
		
		boolean result=statement.execute();
	    System.out.println("Inseretd" + !result);
	}catch(SQLException e) {
		e.printStackTrace();
	}finally {
		try {
			statement.close();
			connection.close();
		}catch(SQLException e) {
		e.printStackTrace();
		}
	}
}
}
