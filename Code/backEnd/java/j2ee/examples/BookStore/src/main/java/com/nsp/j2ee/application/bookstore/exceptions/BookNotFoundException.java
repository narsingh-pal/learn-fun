package com.nsp.j2ee.application.bookstore.exceptions;

public class BookNotFoundException extends Exception {
	private static final long serialVersionUID = -3946866513622075254L;

	private String errorCode="Unknown_Exception";
	
	public BookNotFoundException(Exception e, String errorCode){
		super(e);
		this.errorCode=errorCode;
	}
	
	public String getErrorCode(){
		return this.errorCode;
	}
}
