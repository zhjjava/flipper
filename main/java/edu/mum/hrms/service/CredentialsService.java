package edu.mum.hrms.service;

import edu.mum.core.web.QueryReq;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.model.UserCredentials;

public interface CredentialsService extends IBaseServiceManager {
	public void save(SysUser sysUser);
	public void update(UserCredentials userCredentials);
	public UserCredentials findCredentialsByUserName(QueryReq queryReq, String username);
}
