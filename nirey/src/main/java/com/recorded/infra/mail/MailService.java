package com.recorded.infra.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
    public void sendMailSimple() {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    	
    	simpleMailMessage.setTo("ooyo.che1s@gmail.com");
    	simpleMailMessage.setSubject("회원가입하셨죠?");
//    	simpleMailMessage.setFrom("wjsgusfhr324@gmail.com"); 
    	simpleMailMessage.setText("가입 완료!\n\n 좋은 하루 보내십쇼-!");    

    	javaMailSender.send(simpleMailMessage);

    }
}
