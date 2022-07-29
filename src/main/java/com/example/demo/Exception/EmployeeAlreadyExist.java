package com.example.demo.Exception;

public class EmployeeAlreadyExist extends RuntimeException {

	private String message;
	public EmployeeAlreadyExist() {};	

	public EmployeeAlreadyExist(String message) {
		super(message);
		this.message=message;
	}
}
