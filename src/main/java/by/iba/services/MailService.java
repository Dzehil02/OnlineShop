package by.iba.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	public void sendMessage(String emailTo, String subject, String message) {
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		
		mailMessage.setFrom("dzehil03@gmail.com");
		mailMessage.setTo(emailTo);
		mailMessage.setSubject(subject);
		mailMessage.setText(message);
		
		mailSender.send(mailMessage);
	}
}
