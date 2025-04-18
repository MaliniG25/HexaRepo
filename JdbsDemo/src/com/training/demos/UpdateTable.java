package com.training.demos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class UpdateTable {
	public static void main(String[] args) {
		String url="jdbc:mysql://localhost:3306/trainingdb";
		String username="root";
		String password="Malini@25";
		
		String sql ="update student set department=? where student_id=?";
		Connection connection = null;
		PreparedStatement statement =null;
		try {
			connection = DriverManager.getConnection(url,username,password);
			statement =connection.prepareStatement(sql);
			statement.setString(1, "cst");
			statement.setInt(2, 9);
			int val = statement.executeUpdate();
			System.out.println(val);
			boolean result=statement.execute();
		    System.out.println("Updated" + !result);
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
