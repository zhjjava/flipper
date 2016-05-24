/*
 * @(#)SysCodeDaoImpl.java	2015-6-25上午10:35:22
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Repository;

import edu.mum.core.dao.HibernateEntityDao;
import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.dao.SysCodeDao;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysCode;
import edu.mum.hrms.model.SysCodeCategory;
import edu.mum.hrms.model.SysLocale;
import edu.mum.hrms.util.AppConstants;

/**
 *
 *
 *
 * @author: mz
 * @version: 1.0 Date: Jun 24, 2015 4:24:34 AM
 */
@Repository("sysCodeDao")
public class SysCodeDaoImpl extends HibernateEntityDao<SysCode> implements
		SysCodeDao {

	@Override
	public void deleteLogically(long sysCodeId) throws AppException {
		SysCode curSysCode = get(sysCodeId);
		curSysCode.setStatus(AppConstants.STATUS_INVALID_0);
		update(curSysCode);
	}

	// sample code
	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq)
			throws AppException {
		if (queryReq == null) {
			queryReq = new QueryReq();
		}
		String select = "select e from SysCode e ";
		String where = "";
		String orderBy = "";
		List<Object> paramList = new ArrayList<Object>();
		if (queryFormData != null && isNotBlank(queryFormData.getField1())) {
			where = appendSqlWhere(where, " upper(e.theValue) like ? ");
			paramList.add("%" + StringUtils.upperCase(queryFormData.getField1())
					+ "%");
		}
		if (queryFormData != null && isNotBlank(queryFormData.getField2())) {
			where = appendSqlWhere(where, " e.status=? ");
			paramList.add(Integer.parseInt(queryFormData.getField2()));
		}
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		if (StringUtils.isBlank(queryReq.getOrderBy())) {
			orderBy = "e.sysCodeId";
			queryReq.setOrderBy(orderBy);
		}
		Page page = super.executeQuery(queryReq, pageReq);
		log.debug("ssssssssssssss:" + page.getFullListSize());
		return page;
	}

	public Page findSysCodePage(String categoryId, QueryReq queryReq,
			PageReq pageReq) throws AppException {
		if (queryReq == null) {
			queryReq = new QueryReq();
		}
		String select = "select e from SysCode e ";
		String where = " e.sysCodeCategory.categoryId=" + categoryId
				+ " and e.status=" + AppConstants.STATUS_ENABLED_1;
		String orderBy = "";
		List<Object> paramList = new ArrayList<Object>();
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		if (StringUtils.isBlank(queryReq.getOrderBy())) {
			orderBy = "e.sysCodeId";
			queryReq.setOrderBy(orderBy);
		}
		Page page = super.executeQuery(queryReq, pageReq);
		log.debug("ssssssssssssss:" + page.getFullListSize());
		return page;
	}

	public boolean existsSameKeyOrValue(String categoryId, String theKey,
			String localCode, long sysCodeId) throws AppException {
		boolean result = false;
		QueryReq req = new QueryReq();
		String sql = " select count(e) from SysCode e where e.status="
				+ AppConstants.STATUS_ENABLED_1
				+ " and e.sysCodeCategory.categoryId=" + categoryId;
		if (null != theKey & !theKey.trim().equals("")) {
			sql += " and e.theKey='" + theKey + "'";
		}
		if (null != localCode & !localCode.trim().equals("")) {
			sql += " and e.sysLocale.localeCode='" + localCode + "'";
		}
		if (sysCodeId > 0) {
			sql += " and e.sysCodeId<>" + sysCodeId;
		}
		req.setSelect(sql);
		int count = super.executeCount(req);
		if (count > 0) {
			result = true;
		}
		return result;
	}

	/**
	 * return sysCode data list with SysCode object
	 *
	 * @see getQueryReq(boolean flag, long categoryId, String localeCode,
	 *      Integer status)
	 * @param categoryId
	 * @param localeCode
	 * @param status
	 * @return
	 * @throws AppException
	 */
	public List<SysCode> listSysCode(long categoryId, String localeCode,
			Integer status) throws AppException {
		return super.executeQuery(getQueryReq(false, categoryId, localeCode,
				status));
	}

	/**
	 * return sysCode data list with KeyValueBean object
	 *
	 * @see getQueryReq(boolean flag, long categoryId, String localeCode,
	 *      Integer status)
	 * @param categoryId
	 * @param localeCode
	 * @param status
	 * @return
	 * @throws AppException
	 */
	public List<KeyValueBean> listSysCodeWithLvb(long categoryId,
			String localeCode, Integer status) throws AppException {
		return super.executeQuery(getQueryReq(true, categoryId, localeCode,
				status));
	}

	/**
	 *
	 * @param flag
	 *            ,flag==true means return configuration data with KeyValueBean
	 */
	private static QueryReq getQueryReq(boolean flag, long categoryId,
			String localeCode, Integer status) {
		QueryReq queryReq = new QueryReq();
		String select = "select e from SysCode e ";
		if (flag) {
			select = "select new edu.mum.core.util.KeyValueBean(e.theKey,e.theValue) from SysCode e ";
		}
		String where = "";
		String orderBy = " e.sysCodeCategory.categoryId asc, e.seq asc ";
		List<Object> paramList = new ArrayList<Object>();
		if (categoryId > 0) {
			where = appendSqlWhere(where, " e.sysCodeCategory.categoryId = ? ");
			paramList.add(categoryId);
		}
		if (isNotBlank(localeCode)) {
			where = appendSqlWhere(where, " upper(e.sysLocale.localeCode) = ? ");
			paramList.add(StringUtils.upperCase(localeCode));
		}
		if (status != null) {
			where = appendSqlWhere(where, " e.status = ? ");
			paramList.add(status);
		}
		queryReq.setSelect(select);
		queryReq.setWhere(where);
		queryReq.setParams(paramList.toArray());
		queryReq.setOrderBy(orderBy);
		return queryReq;
	}

	public List<SysCodeCategory> listSysCategoryList() throws AppException {
		QueryReq req = new QueryReq();
		req.setSelect("select e from SysCodeCategory e ");
		req.setWhere("e.status=?");
		req.setParams(new Integer[] { AppConstants.STATUS_VALID_1 });
		List<SysCodeCategory> sysCategoryList = super.executeQuery(req);
		return sysCategoryList;
	}

	public String getValidValueByKey(long categoryId, String key,
			String localCode) throws AppException {
		String valueStr = "";
		QueryReq req = new QueryReq();
		String sql = "select sys from SysCode sys where status="
				+ AppConstants.STATUS_ENABLED_1 + " and sysLocale.localeCode='"
				+ localCode + "' and theKey='" + key + "'"
				+ " and sysCodeCategory.categoryId=" + categoryId;
		req.setSelect(sql);
		List<SysCode> sysList = super.executeQuery(req);
		if (null != sysList && sysList.size() > 0) {
			valueStr = (String) (sysList.get(0).getTheValue());
		} else {
			sql = "select sys from SysCode sys where sysLocale.localeCode='"
					+ AppConstants.SYS_LANGUAGE_EN + "' and theKey='" + key
					+ "'" + " and sysCodeCategory.categoryId=" + categoryId;
			req.setSelect(sql);
			sysList = super.executeQuery(req);
			if (null != sysList && sysList.size() > 0) {
				valueStr = (String) (sysList.get(0).getTheValue());
			}
		}
		return valueStr;
	}

	public String getValueByKey(long categoryId, String key, String localCode)
			throws AppException {
		String valueStr = "";
		QueryReq req = new QueryReq();
		String sql = "select sys from SysCode sys where sysLocale.localeCode='"
				+ localCode + "' and theKey='" + key + "'"
				+ " and sysCodeCategory.categoryId=" + categoryId;
		req.setSelect(sql);
		List<SysCode> sysList = super.executeQuery(req);
		if (null != sysList && sysList.size() > 0) {
			valueStr = (String) (sysList.get(0).getTheValue());
		} else {
			sql = "select sys from SysCode sys where sysLocale.localeCode='"
					+ AppConstants.SYS_LANGUAGE_EN + "' and theKey='" + key
					+ "'" + " and sysCodeCategory.categoryId=" + categoryId;
			req.setSelect(sql);
			sysList = super.executeQuery(req);
			if (null != sysList && sysList.size() > 0) {
				valueStr = (String) (sysList.get(0).getTheValue());
			}
		}
		return valueStr;
	}

	public void testGroupBy() throws AppException {
		QueryReq queryReq = new QueryReq();
		queryReq.setSelect("select new edu.mum.core.util.KeyValueBean(e.sysLocale.localeCode,count(e))"
				+ " from SysCode e  group by e.sysLocale.localeCode");
		PageReq pageReq = new PageReq();
		pageReq.setPageNumber(1);
		pageReq.setPageSize(10);
		List list = super.executeQuery(queryReq, pageReq).getList();
		log.debug("1111111111:" + ((KeyValueBean) list.get(0)).getKey());
	}

	public void testOneTransactionInSysLocale(String localeCode)
			throws AppException {
		SysLocale aSysLocale = new SysLocale();
		aSysLocale.setLocaleCode(localeCode);
		aSysLocale.setLocaleName("TEST_TEST");
		aSysLocale.setSeq(1);
		aSysLocale.setStatus(1);
		super.save(aSysLocale);

		// try set same pk and in another transaction
		aSysLocale = new SysLocale();
		aSysLocale.setLocaleCode(localeCode);
		aSysLocale.setLocaleName("TEST_TEST");
		aSysLocale.setSeq(1);
		aSysLocale.setStatus(1);
		super.save(aSysLocale);
	}

}
