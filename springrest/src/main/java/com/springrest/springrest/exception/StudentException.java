package com.springrest.springrest.exception;

import org.springframework.http.HttpStatus;

public class StudentException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus status;

    public StudentException(String message, Throwable throwable, HttpStatus status) {
        this.message = message;
        this.throwable = throwable;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
