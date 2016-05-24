package edu.mum.hrms.service;

import java.io.Serializable;
import java.util.List;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysDepartment;

public interface DepartmentService extends IBaseServiceManager {

	public  SysDepartment get(Serializable id) throws AppException;
	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
			throws AppException;
	public List<SysDepartment> findDepartments();
	public List find(QueryReq queryReq) throws AppException;
	public void update(Object obj) throws AppException;

	public void save(Object obj) throws AppException;
	public void remove(Object o) throws AppException;

	public void removeById(Serializable id) throws AppException;
}
