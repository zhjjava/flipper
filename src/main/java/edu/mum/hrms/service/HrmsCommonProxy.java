package edu.mum.hrms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.hrms.dao.IBaseManager;
import edu.mum.hrms.model.SysUser;



public interface HrmsCommonProxy extends IBaseManager {



	public List<KeyValueBean> findLocaleValueBeans() throws AppException;
	public boolean authSpecifiedObject(
			String pkOfAuthObject,
			String classType,
			ArrayList<String> authTypes,
			Map authFieldsMap,
			SysUser sysUser);
}