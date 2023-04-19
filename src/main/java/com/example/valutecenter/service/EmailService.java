package com.example.valutecenter.service;


import com.example.valutecenter.model.Email;

public interface EmailService {

    String sendSimpleEmail(Email email);

    String sendEmailWithAttachment(Email email, String attachment);
}
