package com.park.sys.mail;

import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.mail.javamail.JavaMailSender;

@Component
public class EmailSender {
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendEmail(EmailForm emailFomr) throws Exception{
		//皋老 惯价 扁瓷 力傍
		MimeMessage msg = mailSender.createMimeMessage();
		msg.setSubject(emailFomr.getSubject()); //皋老 力格
		msg.setRecipient(RecipientType.TO, new InternetAddress(emailFomr.getReceiver()));
		mailSender.send(msg);
	}
}