package edu.mum.hrms.ws.model;

public class SimpleSysUser {
	private long userId;
	private String loginName;
	private String email;
	
	public SimpleSysUser(){}
	
	public SimpleSysUser(long userId, String loginName, String email) {
		this.userId = userId;
		this.loginName = loginName;
		this.email = email;
	}
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
