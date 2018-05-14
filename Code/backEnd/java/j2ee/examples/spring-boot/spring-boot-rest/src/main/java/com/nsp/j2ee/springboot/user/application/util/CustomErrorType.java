package com.nsp.j2ee.springboot.user.application.util;

public class CustomErrorType {
	 
    private String errorMessage;
 
    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }
 
    public String getErrorMessage() {
        return errorMessage;
    }
 
}