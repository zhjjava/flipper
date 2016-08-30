/*
 * @(#)SysLocaleServiceImpl.java	2015-6-19上午11:48:09
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.core.dao.HibernateEntityDao;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.hrms.dao.SysLocaleDao;
import edu.mum.hrms.model.SysLocale;
import edu.mum.hrms.service.SysLocaleService;

/**
 *
 * @author mz
 *
 */
@Service("sysLocaleService")
public class SysLocaleServiceImpl implements SysLocaleService {

	@Autowired
	private SysLocaleDao sysLocaleDao;

	@Override
	public List<KeyValueBean> listSysLocales() throws AppException {
		return sysLocaleDao.listSysLocales();
	}

	@Override
	public SysLocale get(Serializable id) throws AppException {
		// TODO Auto-generated method stub
		return sysLocaleDao.get(id);
	}

}
