package com.springrest.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class StudentsExcepionHandler {
    @ExceptionHandler(value = {StudentNotFoundException.class})
    public ResponseEntity<Object> handleStudentNotFoundException(StudentNotFoundException ex) {
        StudentException studentException = new StudentException(
                ex.getMessage(),
                ex.getCause(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(studentException, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity <Map<String,String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError)error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName,errorMessage);
        });
        return new ResponseEntity<Map<String,String>>(errors, HttpStatus.BAD_REQUEST);
    }
}
