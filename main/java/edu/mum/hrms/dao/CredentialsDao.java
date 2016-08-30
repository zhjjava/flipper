package edu.mum.hrms.dao;

import java.util.List;

import edu.mum.core.web.QueryReq;
import edu.mum.hrms.model.UserCredentials;

public interface CredentialsDao extends IBaseManager {
//	public void save(UserCredentials userCredentials);
	
	public List<UserCredentials> findAll(QueryReq queryReq);
	public UserCredentials findCredentialsByUserName(QueryReq queryReq, String username);
}
