/*
 * @(#)SysCodeService.java	2015-6-27上午04:58:44
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysCode;
import edu.mum.hrms.model.SysCodeCategory;

/**
 *
 *
 * 类<strong>SysCodeService.java</strong>{此类功能描述}
 *
 * @author: mz
 * @version: 1.0 Date: Jun 24, 2015 4:21:57 AM
 */
public interface SysCodeService extends IBaseServiceManager {
	// add by mz, just declare here
	public SysCode get(Serializable id) throws AppException;

	public Page find(QueryFormData queryFormData, QueryReq queryReq, PageReq pageReq) throws AppException;

	public List<SysCode> listSysCode(long categoryId, String localeCode, Integer status) throws AppException;

	public List<KeyValueBean> listSysCodeWithLvb(long categoryId, String localeCode, Integer status)
			throws AppException;

	public List<SysCodeCategory> listSysCategoryList() throws AppException;

	public String getValueByKey(long categoryId, String key, String localCode) throws AppException;

	public void deleteLogically(long sysCodeId) throws AppException;

	public Page findSysCodePage(String categoryId, QueryReq queryReq, PageReq pageReq) throws AppException;

	public boolean existsSameKeyOrValue(String categoryId, String theKey, String localCode, long sysCodeId)
			throws AppException;

	public String getValidValueByKey(long categoryId, String key, String localCode) throws AppException;

	public void testGroupBy() throws AppException;

	public void testOneTransactionInSysLocale(String localeCode) throws AppException;
	public void update(Object obj) throws AppException;
	public void save(Object obj) throws AppException;
	public void remove(Object o) throws AppException;
	
	//@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void removeById(Serializable id) throws AppException;
}
