package edu.mum.hrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.mum.core.exception.AppException;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.CredentialsDao;
import edu.mum.hrms.model.Authority;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.model.UserCredentials;
import edu.mum.hrms.service.CredentialsService;
import edu.mum.hrms.service.UserService;

@Service(value = "credentialsService")
public class CredentialsServiceImpl implements CredentialsService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CredentialsDao credentialsDao;
	
	@Override
	public void save(SysUser sysUser) {
		UserCredentials userCredentials = new UserCredentials();
		List<Authority> authorities = new ArrayList<Authority>();
		Authority authority = new Authority();
		authority.setAuthority("ROLE_STAFF");
		authority.setUsername(sysUser.getLoginName());
		authorities.add(authority);
		
		sysUser.setStatus(1);
		
		userCredentials.setUsername(sysUser.getLoginName());
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
  		String encodedPassword = passwordEncoder.encode(sysUser.getPassword());
  		userCredentials.setPassword(encodedPassword);
  		userCredentials.setVerifyPassword(encodedPassword);
		userCredentials.setEnabled(true);
		userCredentials.setAuthority(authorities);
		sysUser.setUserCredentials(userCredentials);
		
		try {
			userService.save(sysUser);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(UserCredentials userCredentials) {
		try {
			credentialsDao.update(userCredentials);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public UserCredentials findCredentialsByUserName(QueryReq queryReq, String username) {
		return credentialsDao.findCredentialsByUserName(queryReq, username);
	}
}
