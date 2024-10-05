package com.example.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

	
	@Autowired
    private JavaMailSender javaMailSender;
	
  public void sendEmailWithAttachment(String email) throws MessagingException, IOException {

	       MimeMessage msg = javaMailSender.createMimeMessage();

	       MimeMessageHelper helper = new MimeMessageHelper(msg, true);
	       helper.setTo(email);

	       helper.setSubject("send Email");
	       
	       helper.setText("Hi! I am going to send email to you", true);


	       javaMailSender.send(msg);

	   }
}
