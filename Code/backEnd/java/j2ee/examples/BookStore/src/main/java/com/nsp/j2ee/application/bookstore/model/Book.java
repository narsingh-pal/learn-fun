package com.nsp.j2ee.application.bookstore.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book implements Serializable{
	private static final long serialVersionUID = 4573451999232951695L;
	
	@Column(name="name")
	private String name;
	
	@Column(name="isbn")
	private long isbn;
	
	@Column(name="authors")
	private List<String> authors;
	
	@Column(name="price")
	private double price;
	
	@Column(name="publicationDate")
	private Date publicationDate;
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	public Book(String name, long isbn, List<String> authors, double price, Date publicationDate, long id) {
		super();
		this.name = name;
		this.isbn = isbn;
		this.authors = authors;
		this.price = price;
		this.publicationDate = publicationDate;
		this.id = id;
	}
	
	public Book(Book book) {
		super();
		this.name = book.name;
		this.isbn = book.isbn;
		this.authors = book.authors;
		this.price = book.price;
		this.publicationDate = book.publicationDate;
		this.id = book.id;
	}
	
	public Book( ) {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		this.publicationDate = publicationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authors == null) ? 0 : authors.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (isbn ^ (isbn >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((publicationDate == null) ? 0 : publicationDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (authors == null) {
			if (other.authors != null)
				return false;
		} else if (!authors.equals(other.authors))
			return false;
		if (id != other.id)
			return false;
		if (isbn != other.isbn)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (publicationDate == null) {
			if (other.publicationDate != null)
				return false;
		} else if (!publicationDate.equals(other.publicationDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [name=" + name + ", isbn=" + isbn + ", authors=" + authors + ", price=" + price
				+ ", publicationDate=" + publicationDate + ", id=" + id + "]";
	}

	
	
	
	
	
}
