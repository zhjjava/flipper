/*
 * @(#)SysLocaleService.java	2015-6-19上午11:46:38
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.dao;

import java.io.Serializable;
import java.util.List;

import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.hrms.model.SysLocale;

/**
 *
 * 类<strong>SysLocaleService.java</strong>{此类功能描述}
 *
 * @author: mz
 * @version: 1.0 Date: 2015-6-19 上午11:46:38
 */
public interface SysLocaleDao extends IBaseManager {

	// add by mz, just declare here
	public SysLocale get(Serializable id) throws AppException;

	/**
	 * 获取语言种类列表
	 *
	 * @return
	 * @throws AppException
	 */
	public List<KeyValueBean> listSysLocales() throws AppException;
}
