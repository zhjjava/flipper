/*
 * @(#)SysLocaleService.java	2015-6-19上午11:46:38
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.service;

import java.io.Serializable;
import java.util.List;

import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.hrms.model.SysLocale;

/**
 *
 * @author mz
 *
 */
public interface SysLocaleService extends IBaseServiceManager {

	// add by mz, just declare here
	public SysLocale get(Serializable id) throws AppException;

	public List<KeyValueBean> listSysLocales() throws AppException;
}
