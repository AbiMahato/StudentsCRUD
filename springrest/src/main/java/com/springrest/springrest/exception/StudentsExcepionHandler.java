package com.springrest.springrest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
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
}
