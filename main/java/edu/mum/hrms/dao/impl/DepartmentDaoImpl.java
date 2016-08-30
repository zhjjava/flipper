package edu.mum.hrms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import edu.mum.core.dao.HibernateEntityDao;
import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.DepartmentDao;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.model.SysUser;


@Repository("departmentDao")
public class  DepartmentDaoImpl extends HibernateEntityDao<SysDepartment>
    implements DepartmentDao{

	protected static Logger logger = LoggerFactory.getLogger(DepartmentDaoImpl.class);	

	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
			throws AppException {
		if (queryReq == null) {
			queryReq = new QueryReq();
		}
		String select = "select e from SysDepartment e ";
		String where = "e.departStatus=1";
		String orderBy = "";
		List<Object> paramList = new ArrayList<Object>();
		if (queryFormData != null && isNotBlank(queryFormData.getField1())) {
			where = appendSqlWhere(where, " upper(e.departName) like ? ");
			paramList.add("%" + StringUtils.upperCase(queryFormData.getField1())
					+ "%");
		}
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		if (StringUtils.isBlank(queryReq.getOrderBy())) {
			orderBy = "e.departNum";
			queryReq.setOrderBy(orderBy);
		}
		Page page = super.executeQuery(queryReq, pageReq);
		log.debug("ssssssssssssss:" + page.getFullListSize());
		for(Object object:page.getList()){
			SysDepartment department=(SysDepartment) object;
			department.setMajor(get(SysUser.class, department.getDepartMajor()));
		}
		log.debug("ssssssssssssss:" + page.getFullListSize());
		return page;
	}

	public List<SysDepartment> findDepartments(){
		List list	=null;
		try {
			QueryReq queryReq = new QueryReq();
			String select = "select e from SysDepartment e ";
			String where="";
			queryReq.setSelect(select);
			queryReq.setWhere(where);
			 list = super.executeQuery(queryReq);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List find(QueryReq queryReq) throws AppException {
		if (queryReq == null) {
			queryReq = new QueryReq();
		}
		String select = "select d from SysDepartment d ";
		String where = "";
		String orderBy = "";
		List<Object> paramList = new ArrayList<Object>();
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		if (StringUtils.isBlank(queryReq.getOrderBy())) {
			orderBy = "d.departId";
			queryReq.setOrderBy(orderBy);
		}
		List list = super.executeQuery(queryReq);
		return list;
	}

//	@Override
//	public void update(Object obj) throws AppException {
//		// TODO Auto-generated method stub
//		super.merge(obj);
//	}
}
