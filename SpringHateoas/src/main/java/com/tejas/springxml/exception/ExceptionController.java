package com.tejas.springxml.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler{
	

	@ExceptionHandler(value = Employeenamenotfound.class)
	public ResponseEntity<Object> exception(Employeenamenotfound exception) {
		return new ResponseEntity<Object>("Employee name not found exception",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmployeeValue.class)
	public ResponseEntity<Object> exception(EmployeeValue exception)
	{
		return new ResponseEntity<Object>("Employee pass to post is not valid",HttpStatus.NOT_FOUND);
	}
}