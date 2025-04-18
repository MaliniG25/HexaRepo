package com.bookapp.client;


	import com.bookapp.dao.IBookDaoImpl;

import java.util.List;

import com.bookapp.dao.IBookDao;
	import com.bookapp.model.Book;

	public class Client {
		
		public static void main(String args[]) {
			Book book=new Book("Java","kathy","Tech",1,2000);
			IBookDao bookDao=new IBookDaoImpl();
			bookDao.addBook(book);
			
		List<Book> books=bookDao.getAllBooks();
		for(Book nbook:books)
			System.out.println(nbook);
		}
}
