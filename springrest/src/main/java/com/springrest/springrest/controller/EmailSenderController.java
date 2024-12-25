package com.springrest.springrest.controller;

import com.springrest.springrest.dto.EmailRequestDto;
import com.springrest.springrest.service.EmailSenderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmailSenderController {
    private Logger logger = LoggerFactory.getLogger(EmailSenderController.class);
    private final EmailSenderService emailSenderService;

    public EmailSenderController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }
    @PostMapping("/send-emails")
    public void sendEmail2(@RequestBody EmailRequestDto emailRequest) throws InterruptedException {
        logger.info("before email sent " + Thread.currentThread().getName());
        List<String> emails = emailRequest.getEmails();
        for (String email : emails) {
            emailSenderService.sendEmail(email, emailRequest.getSubject(), emailRequest.getMessage());
        }
        Thread.sleep(20000);
        logger.info("message after email sent " + Thread.currentThread().getName());
    }
}
