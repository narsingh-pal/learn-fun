package com.nsp.j2ee.application.bookstore.service;

import java.util.Date;
import java.util.List;

import com.nsp.j2ee.application.bookstore.model.Book;

public interface BookStoreService {

	public void addBook(Book book);
	public void addBooks(List<Book> books);
	public Book getBook(Book book);
	public Book getBookByIsbn(long isbn);
	public Book getBookByTitle(String title);
	public List<Book> getBooksByAuthor(String author);
	public List<Book> getBooksByPublicationDate(Date date);
	public List<Book> getBooksByPublicationDateRange(Date startDate , Date endDate);
	
	public Book updateBookByIsbn(long isbn, Book updatedBook);
	public Book updateBookByTitle(String title, Book updatedBook);
	
	
	public Book deleteBook(Book book);
	public Book deleteBookByIsbn(long isbn);
	public Book deleteBookByTitle(String title);
	public List<Book> deleteBooksByAuthor(String author);
	public List<Book> deleteBooksByPublicationDate(Date date);
	public List<Book> deleteBooksByPublicationDateRange(Date startDate , Date endDate);
}
