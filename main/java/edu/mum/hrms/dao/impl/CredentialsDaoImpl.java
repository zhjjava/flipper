package edu.mum.hrms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import edu.mum.core.dao.HibernateEntityDao;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.CredentialsDao;
import edu.mum.hrms.model.UserCredentials;

@Repository
public class CredentialsDaoImpl extends HibernateEntityDao<UserCredentials> implements CredentialsDao {

	@Override
	public UserCredentials findCredentialsByUserName(QueryReq queryReq, String username) {
		List<UserCredentials> credentialsList = findAll(queryReq);
		
		for(UserCredentials uc : credentialsList){
			if(uc.getUsername().equals(username)){
				return uc;
			}
		}
		
		return null;
	}

	@Override
	public List<UserCredentials> findAll(QueryReq queryReq) {
		if (queryReq == null) {
			queryReq = new QueryReq();
		}
		String select = "select d from UserCredentials d ";
		String where = "";
		String orderBy = "";
		List<Object> paramList = new ArrayList<Object>();
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		if (StringUtils.isBlank(queryReq.getOrderBy())) {
			orderBy = "d.username";
			queryReq.setOrderBy(orderBy);
		}
		
		List list = null;
		
		try {
			list = super.executeQuery(queryReq);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}


//	@Override
//	public List find(QueryReq queryReq) throws AppException {
//		if (queryReq == null) {
//			queryReq = new QueryReq();
//		}
//		String select = "select d from SysDepartment d ";
//		String where = "";
//		String orderBy = "";
//		List<Object> paramList = new ArrayList<Object>();
//		queryReq.setSelect(select);
//		queryReq.setWhere(where);
//		queryReq.setParams(paramList.toArray());
//		if (StringUtils.isBlank(queryReq.getOrderBy())) {
//			orderBy = "d.departId";
//			queryReq.setOrderBy(orderBy);
//		}
//		List list = super.executeQuery(queryReq);
//		return list;
//	}
	
	
}

