package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Email;
import com.example.service.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@PostMapping("/send")
	public String sendEmail(@RequestBody Email tempEmail){
		
		try {
			System.out.println("Email Send......");
			emailService.sendEmailWithAttachment(tempEmail.getEmail());
			System.out.println("Done...");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "Email Send Successfully..";
	}
}