/*
 * @(#)SysCodeServiceImpl.java	2015-6-25上午10:35:22
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

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
import edu.mum.hrms.service.SysCodeService;

/**
 *
 *
 * 类<strong>SysCodeServiceImpl.java</strong>{此类功能描述}
 *
 * @author: mz
 * @version: 1.0 Date: Jun 24, 2015 4:24:34 AM
 */
@Service("sysCodeService")
public class SysCodeServiceImpl implements SysCodeService {

	@Autowired
	private SysCodeDao sysCodeDao;

	@Override
	public void deleteLogically(long sysCodeId) throws AppException {
		sysCodeDao.deleteLogically(sysCodeId);
	}

	// sample code
	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq) throws AppException {
		return sysCodeDao.find(queryFormData, queryReq, pageReq);
	}

	public Page findSysCodePage(String categoryId, QueryReq queryReq, PageReq pageReq) throws AppException {
		return sysCodeDao.findSysCodePage(categoryId, queryReq, pageReq);
	}

	public boolean existsSameKeyOrValue(String categoryId, String theKey, String localCode, long sysCodeId)
			throws AppException {
		return sysCodeDao.existsSameKeyOrValue(categoryId, theKey, localCode, sysCodeId);
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
	public List<SysCode> listSysCode(long categoryId, String localeCode, Integer status) throws AppException {
		return sysCodeDao.listSysCode(categoryId, localeCode, status);
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
	public List<KeyValueBean> listSysCodeWithLvb(long categoryId, String localeCode, Integer status)
			throws AppException {
		return sysCodeDao.listSysCodeWithLvb(categoryId, localeCode, status);
	}

	public List<SysCodeCategory> listSysCategoryList() throws AppException {
		return sysCodeDao.listSysCategoryList();
	}

	public String getValidValueByKey(long categoryId, String key, String localCode) throws AppException {

		return sysCodeDao.getValidValueByKey(categoryId, key, localCode);
	}

	public String getValueByKey(long categoryId, String key, String localCode) throws AppException {
		return sysCodeDao.getValueByKey(categoryId, key, localCode);
	}

	public void testGroupBy() throws AppException {
		sysCodeDao.testGroupBy();
	}

	public void testOneTransactionInSysLocale(String localeCode) throws AppException {
		SysLocale aSysLocale = new SysLocale();
		aSysLocale.setLocaleCode(localeCode);
		aSysLocale.setLocaleName("TEST_TEST");
		aSysLocale.setSeq(1);
		aSysLocale.setStatus(1);
		sysCodeDao.save(aSysLocale);

		// try set same pk and in another transaction
		aSysLocale = new SysLocale();
		aSysLocale.setLocaleCode(localeCode);
		aSysLocale.setLocaleName("TEST_TEST");
		aSysLocale.setSeq(1);
		aSysLocale.setStatus(1);
		sysCodeDao.save(aSysLocale);
	}

	@Override
	public SysCode get(Serializable id) throws AppException {
		return sysCodeDao.get(id);
	}

	public void update(Object obj) throws AppException{
		sysCodeDao.update(obj);
	}
	
	public void save(Object obj) throws AppException{
		sysCodeDao.save(obj);
	}


	public void remove(Object o) throws AppException{
		sysCodeDao.remove(o);
	}

	public void removeById(Serializable id) throws AppException{
		sysCodeDao.removeById(id);
	}
}
