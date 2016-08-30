package edu.mum.hrms.ws.service;

import java.util.List;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.ws.model.SimpleSysUser;

public interface SysUserWSService {
	public List<SimpleSysUser> getAllUsers() throws AppException;
	public SimpleSysUser findUserById(long id) throws AppException;
	public void addUser(SimpleSysUser user) throws AppException;
	public void updateUser(SimpleSysUser user) throws AppException;
	public void deleteUser(SimpleSysUser user) throws AppException;
}
