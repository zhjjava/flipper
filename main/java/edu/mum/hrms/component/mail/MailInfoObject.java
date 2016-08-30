package edu.mum.hrms.component.mail;

import java.io.Serializable;

import edu.mum.hrms.model.SysUser;

public class MailInfoObject implements Serializable{
	private String subject;
	private SysUser sysUser;
	private String recipients;
	private String from;

	


	public MailInfoObject(String subject, SysUser sysUser, String recipients, String from) {
		super();
		this.subject = subject;
		this.sysUser = sysUser;
		this.recipients = recipients;
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getRecipients() {
		return recipients;
	}

	public void setRecipients(String recipients) {
		this.recipients = recipients;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public SysUser getSysUser() {
		return sysUser;
	}

	public void setSysUser(SysUser sysUser) {
		this.sysUser = sysUser;
	}

}
