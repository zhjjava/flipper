package edu.mum.hrms.ws.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.dao.UserDao;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.ws.model.SimpleSysUser;
import edu.mum.hrms.ws.service.SysUserWSService;

@Transactional
@Service
public class SysUserWSServiceImpl implements SysUserWSService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public List<SimpleSysUser> getAllUsers() throws AppException{
		List<SimpleSysUser> users = new ArrayList<SimpleSysUser>();
		List<SysUser> sysUsers = userDao.findUsers();
		
		for(SysUser u : sysUsers){
			SimpleSysUser user = new SimpleSysUser(u.getUserId(), u.getLoginName(), u.getPersonalEmail());
			users.add(user);
		}
		
		return users;
	}

	@Override
	public SimpleSysUser findUserById(long id) throws AppException {
		SysUser user = userDao.get(id);
		return new SimpleSysUser(user.getUserId(), user.getLoginName(), user.getPersonalEmail());
	}

	@Override
	public void addUser(SimpleSysUser user) throws AppException {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(user.getLoginName());
		sysUser.setPersonalEmail(user.getEmail());
		
		userDao.save(sysUser);
	}

	@Override
	public void deleteUser(SimpleSysUser user) throws AppException {
		SysUser sysUser = new SysUser();
		sysUser.setLoginName(user.getLoginName());
		sysUser.setPersonalEmail(user.getEmail());
		sysUser.setUserId(user.getUserId());
		
		userDao.remove(sysUser);
	}

	@Override
	public void updateUser(SimpleSysUser user) throws AppException {
		SysUser sysUser = new SysUser();
		sysUser.setUserId(user.getUserId());
		sysUser.setLoginName(user.getLoginName());
		sysUser.setPersonalEmail(user.getEmail());
		
		userDao.update(sysUser);
	}
}
