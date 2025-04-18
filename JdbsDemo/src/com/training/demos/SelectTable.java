package com.training.demos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class SelectTable {
public static void main(String[] args) {
	String url="jdbc:mysql://localhost:3306/trainingdb";
	String username="root";
	String password="Malini@25";
	
	String sql ="select * from student";
	Connection connection = null;
	PreparedStatement statement =null;
	try {
		connection = DriverManager.getConnection(url,username,password);
		statement =connection.prepareStatement(sql);
		 ResultSet rs = statement.executeQuery();
		 while(rs.next()) {
			 String studentName = rs.getString("student_name");
			 int studentId = rs.getInt("student_id");
			 String department=rs.getString(3);
			 System.out.println(studentName + "\t"+studentId+"\t"+department);
			 		
		 }
		
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
