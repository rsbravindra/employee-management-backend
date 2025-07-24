package com.test.ems.exception;

public class EmployeeAlreadyExistsException extends RuntimeException{
    private String errorMessage;
    public EmployeeAlreadyExistsException(String message) {
        super(message);
    }
    public EmployeeAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
