package com.university.address_service.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ValidationExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
	
//	- ConstraintViolationException won't trigger for @PathVariable validation unless @Validated is added at the controller level.
//	- Instead, Spring Boot may throw MethodArgumentNotValidException or MethodArgumentTypeMismatchException.
//	- Using @Validated ensures @Min is processed correctly.


	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleContraintExceptions(ConstraintViolationException ex) {
       String error = " Id should be greater than 1 : "+ex.getMessage();
        
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
	
	
}
