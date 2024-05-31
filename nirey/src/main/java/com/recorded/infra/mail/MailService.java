package com.recorded.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.recorded.infra.member.MemberDto;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendMailSimple(MemberDto dto) {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	
    	simpleMailMessage.setTo(dto.getEmail());
    	simpleMailMessage.setSubject("Welcome to recorded!");
    	simpleMailMessage.setText("Nice to meet you " + dto.getName() + "!\n\n I hope you have a great time at recorded🩷");    

    	javaMailSender.send(simpleMailMessage);

    }
}
