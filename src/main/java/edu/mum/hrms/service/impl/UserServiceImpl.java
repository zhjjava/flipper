package edu.mum.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.UserDao;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.data.QueryFormDataUser;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.service.UserService;

@Service(value = "userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	public List<SysDepartment> getDept() throws AppException {
		return userDao.getDept();
	}

	public List<SysUser> findUsers(QueryFormDataUser qryFormData) throws AppException {
		return userDao.findUsers(qryFormData);
	}

	public SysUser getByQuery(QueryFormDataUser qryFormData) throws AppException {
		return userDao.getByQuery(qryFormData);
	}

	public SysUser getLoginUser(String loginName) throws AppException {
		return userDao.getLoginUser(loginName);
	}


	@Override
	public SysUser get(Serializable id) throws AppException {
		return userDao.get(id);
	}

	@Override
	public Page findUser(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq) throws AppException {
		return userDao.findUser(queryFormData, queryReq, pageReq);
	}
	public void update(Object obj) throws AppException{
		userDao.update(obj);
	}
	public void save(Object obj) throws AppException{
		userDao.save(obj);
	}


	public void remove(Object o) throws AppException{
		userDao.remove(o);
	}

	public void removeById(Serializable id) throws AppException{
		userDao.removeById(id);
	}

	@Override
	public SysUser getAuthenticatedUser(String loginName, String password) throws AppException {
		
		Authentication request = null;
		Authentication result = null;
		SysUser rtnSysUser = null;
		try{	  		
			request = new UsernamePasswordAuthenticationToken(loginName, password);
			result = authenticationManager.authenticate(request);
			
			SecurityContextHolder.getContext().setAuthentication(result);
			rtnSysUser = userDao.getLoginUser(loginName);
		    System.out.println("Successfully authenticated. Security context contains: " +
		              SecurityContextHolder.getContext().getAuthentication());
		}catch(AuthenticationException e){
			System.out.println();
			System.out.println("Authentication failed: " + e.getMessage());
		}
		
		return rtnSysUser;
	}	
	
	
	public SysUser getSysUserByEmail(String email) throws AppException {
		return userDao.getSysUserByEmail(email);
	}
}
