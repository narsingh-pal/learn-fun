package com.nsp.j2ee.springmvc.rest.user.application.util;

public class CustomErrorType {
	 
    private String errorMessage;
 
    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
}