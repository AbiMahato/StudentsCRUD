package com.springrest.springrest.dto;

import java.util.List;


public class EmailRequestDto {
    private List<String> emails;
    private String subject;
    private String message;

    public EmailRequestDto() {};
    public EmailRequestDto(List<String> emails, String subject, String message) {
        this.emails = emails;
        this.subject = subject;
        this.message = message;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
