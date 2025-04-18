package com.financemanagementapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.financemanagementapp.entity.Expense;
import com.financemanagementapp.entity.User;
import com.financemanagementapp.exceptions.ExpenseNotFoundException;
import com.financemanagementapp.exceptions.UserNotFoundException;
import com.financemanagementapp.util.DbConnectionUtil;

public class FinanceRepositoryImpl implements IFinanceRepository {
    public  Connection connection;
    
	@Override
	public void  createUser(User user) {
		connection=DbConnectionUtil.getConnection();
		String query = "INSERT INTO Users  VALUES (?, ?, ?,?)";
		PreparedStatement statement=null;
        try {
           statement = connection.prepareStatement(query); 
           statement.setInt(1, user.getUserId());
           statement.setString(2, user.getUsername());
           statement.setString(3, user.getPassword());
           statement.setString(4, user.getEmail());
           statement.execute();
        } catch (SQLException e) {
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

	@Override
	public void deleteUser(int userId) {
	    
	    connection = DbConnectionUtil.getConnection();
        String query = "DELETE FROM Users WHERE userId = ?";
        PreparedStatement statement=null;
	    try {
	        
	        statement = connection.prepareStatement(query);
	        statement.setInt(1,userId);

	        int rowsDeleted = statement.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("User with ID " + userId + " was deleted successfully.");
	        } else {
	            System.out.println("No user found with ID " + userId);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (statement != null) statement.close();
	            if (connection != null) connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	@Override
	public void createExpense(Expense expense) {
		
	
}

	@Override
	public void deleteExpense(int expenseId) {
		
}

	@Override
	public List getAllExpenses(int userId) {
		return null;
		
	}

	@Override
	public void updateExpense(int userId, Expense expense) {
		
	}
}


