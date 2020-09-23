package com.capg.exception;
@SuppressWarnings("serial")
public class IdAlreadyExistException extends Exception {
	public  IdAlreadyExistException(String errorMsg){
		super(errorMsg);
	}
}