/*
 * @(#)IMimeMailService.java	2011-2-20上午03:42:33
 * Copyright 2010 IBM and ChinaVisa All rights reserved.
 */
package edu.mum.hrms.component.mail;

import org.springframework.mail.javamail.JavaMailSender;

import edu.mum.core.exception.AppException;

/**
 * 
 *
 * @author: mz 
 */
public interface MailService {

	/**
	 * Spring的MailSender.
	 */
	public abstract void setMailSender(JavaMailSender mailSender);

	/**
	 * sample: sendText("subject","email content","1@test.com;2@test.com");
	 * 
	 * @param subject
	 * @param emailContent
	 * @param email
	 * @throws AppException
	 */
	public abstract void sendText(String subject, String emailContent,String email) throws Exception;
	
	/**
	 * 
	 * 
	 * sendText("subject","email content","1@test.com","2@test.com");
	 * sendText("subject","email content",new String[]{"1@test.com","2@test.com"});
	 * 
	 * @param subject
	 * @param emailContent
	 * @param email
	 * @throws AppException
	 */	
	public abstract void sendText(String subject, String emailContent,String ... email) throws Exception;

	public abstract void sendMimeMessage() throws Exception;

}
