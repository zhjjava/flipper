package edu.mum.hrms.component.integration;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.hrms.component.mail.EmailService;
import edu.mum.hrms.component.mail.MailInfoObject;


public class AlbiaMessageListener implements MessageListener {
    private static final Logger logger = LoggerFactory.getLogger(AlbiaMessageListener.class);

	 @Autowired
	 private EmailService emailService = null;
    
    public void onMessage(Message message) {
        ObjectMessage objectMessage = (ObjectMessage) message;
        MailInfoObject mailInfoObject = null;
		try {
			mailInfoObject = (MailInfoObject) objectMessage.getObject();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("ALBIA - Message received: " );
        System.out.println("         product Name: "  + mailInfoObject.getRecipients());
        System.out.println("ALBIA - Sending mail:" );
        try {
			emailService.sendResetPasswordMail(mailInfoObject.getSysUser().getFirstName(), mailInfoObject.getRecipients(), mailInfoObject.getSysUser(), null);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("ALBIA - Sending mail finished." );
    }
}
