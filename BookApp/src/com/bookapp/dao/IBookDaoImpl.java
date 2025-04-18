package com.bookapp.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.bookapp.model.Book;
import com.bookapp.util.DbConnectionUtil;

public class IBookDaoImpl implements IBookDao {
    
	@Override
	public void addBook(Book book) {
		connection=DbConnectionUtil.getConnection();
        String sql ="insert into book values(?,?,?,?,?)";
        PreparedStatement statement=null;
        try {
        	statement=connection.prepareStatement(sql);
        	statement.setString(1,book.getTitle());
        	statement.setString(2,book.getAuthor());
        	statement.setInt(3,book.getBookId());
        	statement.setString(4,book.getCategory());
        	statement.setDouble(5,book.getPrice());
        	statement.execute();
        }catch(SQLException e) {
        	e.printStackTrace();
        }
    
	}

	@Override
	public void updateBook(int bookId, float price) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBook(int bookId) {
		// TODO Auto-generated method stub

	}

	@Override
	public Book getById(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooks() {
		connection=DbConnectionUtil.getConnection();
        String sql ="select* from book";
        PreparedStatement statement=null;
        List<Book> books=new ArrayList<Book>();
        
	}try {
		
		statement =connection.prepareStatement(sql);
		 ResultSet rs = statement.executeQuery();
		 while(rs.next()) {
			 String title = rs.getString("title");
			 int bookId = rs.getInt("bookid");
			 String author=rs.getString("author");
			 String category=rs.getString("category");
			 String price=rs.getDouble("price");
			 Book book = new Book(title,author,category,bookId,price);
			 books.add(book);
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
		return null;
	}

	@Override
	public List<Book> getByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}

}
