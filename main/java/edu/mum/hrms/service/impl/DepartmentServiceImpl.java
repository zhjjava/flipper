package edu.mum.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.DepartmentDao;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.service.DepartmentService;


@Service(" departmentService")
public class  DepartmentServiceImpl  implements DepartmentService{

	@Autowired
	private DepartmentDao departmentDao;

	protected static Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);


	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
			throws AppException {
		return departmentDao.find(queryFormData, queryReq, pageReq);
	}

//
	public List<SysDepartment> findDepartments(){
		return departmentDao.findDepartments();
	}

	@Override
	public List find(QueryReq queryReq) throws AppException {
		return departmentDao.find(queryReq);
	}

	@Override
	public SysDepartment get(Serializable id) throws AppException {
		return departmentDao.get(id);
	}
	public void update(Object obj) throws AppException{
		departmentDao.update(obj);
	}
	public void save(Object obj) throws AppException{
		departmentDao.save(obj);
	}

	public void remove(Object o) throws AppException{
		departmentDao.remove(o);
	}

	public void removeById(Serializable id) throws AppException{
		departmentDao.removeById(id);
	}

}
