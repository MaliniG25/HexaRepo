package com.bookapp.model;

public class Book {
 String title;
 String author;
 String category;
 int bookId;
 float price;
 Book() {}
public Book(String title, String author, String category, int bookId, float price) {
	super();
	this.title = title;
	this.author = author;
	this.category = category;
	this.bookId = bookId;
	this.price = price;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public int getBookId() {
	return bookId;
}
public void setBookId(int bookId) {
	this.bookId = bookId;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Book [title=" + title + ", author=" + author + ", category=" + category + ", bookId=" + bookId + ", price="
			+ price + "]";
}
 
}
