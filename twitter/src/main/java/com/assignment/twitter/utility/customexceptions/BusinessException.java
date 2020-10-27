package com.assignment.twitter.utility.customexceptions;

public class BusinessException extends Exception{

	public BusinessException(Exception e) {
		super(e.getMessage(),e);
	}
	
	public BusinessException(String string) {
		super(string);
	}

}
