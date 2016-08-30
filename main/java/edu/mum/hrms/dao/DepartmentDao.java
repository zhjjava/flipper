package edu.mum.hrms.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysDepartment;

public interface DepartmentDao extends IBaseManager {

	public  SysDepartment get(Serializable id) throws AppException;
//	public Page listAll(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
//			throws AppException;
	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
			throws AppException;

	public List<SysDepartment> findDepartments();
	public List find(QueryReq queryReq) throws AppException;
}
