package edu.mum.hrms.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.data.QueryFormDataUser;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.model.SysUser;

public interface UserService extends IBaseServiceManager {
	public Page findUser(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq) throws AppException;

	public SysUser get(Serializable id) throws AppException;

	public List<SysDepartment> getDept() throws AppException;

	public SysUser getLoginUser(String loginName) throws AppException;

	public SysUser getByQuery(QueryFormDataUser qryFormData) throws AppException;

	public List<SysUser> findUsers(QueryFormDataUser qryFormData) throws AppException;

	public void update(Object obj) throws AppException;
	public void save(Object obj) throws AppException;

	public void remove(Object o) throws AppException;

	public void removeById(Serializable id) throws AppException;
	
	public SysUser getAuthenticatedUser(String loginName, String password) throws AppException; 
	
	public SysUser getSysUserByEmail(String email) throws AppException;
}
