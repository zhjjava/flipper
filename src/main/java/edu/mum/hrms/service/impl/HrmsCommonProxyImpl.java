package edu.mum.hrms.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.core.dao.HibernateGenericDao;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.BeanUtilsEx;
import edu.mum.core.util.KeyValueBean;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.service.HrmsCommonProxy;
import edu.mum.hrms.util.AppConstants;


/**
 * need to adjust this implementation according to the actual requirements
 * @author mz
 *
 */
@SuppressWarnings("unchecked")
@Service("hrmsCommonProxy")
public class HrmsCommonProxyImpl extends HibernateGenericDao implements HrmsCommonProxy {
	protected static Logger log = LoggerFactory.getLogger(HrmsCommonProxyImpl.class);

	public List<KeyValueBean> findLocaleValueBeans() throws AppException {
  		List rtnList = null;
  		try {
  			String hql = " select new edu.mum.core.util.KeyValueBean(e.localeCode,e.localeName) from SysLocale e ";

  			rtnList = super.find(hql,null);
  		} catch (Exception e) {
  			handleException(e);
  		}
  		return rtnList;
  	}

	@Transactional(readOnly=true)
	public boolean authSpecifiedObject(
			String pkOfAuthObject,
			String classType,
			ArrayList<String> authTypes,
			Map authFieldsMap,
			SysUser sysUser) {
		// String authDataConf =
		// "{'authObject':{'pkFieldNameInParas':'id','classType':'org.visaforchina.cvasc.model.PickupForm'},"
		// + "'authFields':{'countryCode':'ARE','visacenter.nameCh':'zhj','userIdFieldName':'createId'," +
		// "'vcIdFieldName':'visacenter.visacenterId'},"
		// + "'authType':['owner','visacenter','self']}";

		try {
			if (StringUtils.isBlank(pkOfAuthObject)) {
				log.error("The specified pkOfAuthObject is null.");
				return false;
			}
			if (StringUtils.isBlank(classType)) {
				log.error("The specified classType is null.");
				return false;
			}
			// if classType not contains ., then plus default class package
			if (classType.indexOf(".") == -1) {
				classType = AppConstants.DEFAULT_CLASS_PACKAGE + classType;
			}
			if (CollectionUtils.isEmpty(authTypes)) {
				log.warn("Can not find any authType. Just return true.");
				return true;
			}
			Object targetObj = super.get(Class.forName(classType), Long.parseLong(pkOfAuthObject));

			if (authFieldsMap == null || authFieldsMap.isEmpty()) {
				log.error("authFieldsMap should not be empty.");
				return false;
			}

			for (String authType : authTypes) {
				if (AppConstants.AUTH_TYPE_OWNER.equals(authType)) {
					String userIdFieldName = (String)authFieldsMap.get(AppConstants.USER_ID_FIELD_NAME);
					if (!getResultOfComparingFieldValue(targetObj, userIdFieldName, sysUser.getUserId())) {
						log.warn("It's a valid request, wrong user id.");
						return false;
					}
				}
//				else if (AppConstants.AUTH_TYPE_VISACENTER.equals(authType)) {
//					String vcIdFieldName = (String)authFieldsMap.get(AppConstants.VC_ID_FIELD_NAME);
//					if (!getResultOfComparingFieldValue(targetObj, vcIdFieldName, sysUser.getVisacenterId())) {
//						log.warn("It's a valid request, wrong visacenter id.");
//						return false;
//					}
//				}
				else if (AppConstants.AUTH_TYPE_SELF.equals(authType)) {
					if (!authSpecifiedFields(targetObj, authFieldsMap)) {
						log.warn("It's a valid request, wrong data status.");
						return false;
					}
				}
			}
		}
		catch (Exception e) {
			log.error("authticate data failed.", e);
			return false;
		}

		return true;
	}

	@Transactional(readOnly=true)
	private boolean authSpecifiedFields(Object targetObj, Map authFieldsMap) throws Exception {
		Set<Map.Entry> set = authFieldsMap.entrySet();
		Entry entry = null;
		String toBeCheckedField = "";
		String toBeComparedValue = "";
		for (Iterator it = set.iterator(); it.hasNext();) {
			entry = (Entry)it.next();
			toBeCheckedField = String.valueOf(entry.getKey());
			toBeComparedValue = String.valueOf(entry.getValue());
			// is userId field or visacenter field, just ignore it.
			if (AppConstants.USER_ID_FIELD_NAME.equals(toBeCheckedField)
				|| AppConstants.VC_ID_FIELD_NAME.equals(toBeCheckedField)) {
				continue;
			}
			log.debug("toBeCheckedField:" + toBeCheckedField + ";;toBeComparedValue:" + toBeComparedValue);

			if (!getResultOfComparingFieldValue(targetObj, toBeCheckedField, toBeComparedValue)) {
				return false;
			}
		}
		return true;
	}

	@Transactional(readOnly=true)
	private static boolean getResultOfComparingFieldValue(
			Object targetObj,
			String fieldNameStack,
			Object toBeComparedValue) throws Exception {
		if (targetObj == null) {
			return false;
		}
		if (StringUtils.isEmpty(fieldNameStack)) {
			return false;
		}
		Object foundValueObject = targetObj;
		if (fieldNameStack.indexOf(".") > 0) {
			String[] fieldArr = fieldNameStack.split("\\.");
			for (String field : fieldArr) {
				log.debug("field:" + field);
				foundValueObject = BeanUtilsEx.forceGetProperty(foundValueObject, field);
				if (foundValueObject == null) {
					log.warn("Target object is null");
					// return false;//maybe just compare null value
					break;
				}
			}
		}
		else {
			foundValueObject = BeanUtils.getProperty(foundValueObject, fieldNameStack);
		}
		log.debug("fieldNameStack:" + fieldNameStack + ";;foundValueObject:" + String.valueOf(foundValueObject)
					+ ";;toBeComparedValue:" + String.valueOf(toBeComparedValue));
		// really compare the blank property
		if (foundValueObject == null) {
			if (toBeComparedValue == null || StringUtils.isBlank(toBeComparedValue.toString())
				|| AppConstants.NULL_VALUE.equals(toBeComparedValue)) {
				return true;
			}
			else {
				return false;
			}
		}
		return (String.valueOf(foundValueObject).equals(String.valueOf(toBeComparedValue)));
	}

	@Override
	public void removeById(Serializable id) throws AppException {
		throw new AppException("Should use the self service to delete this entity.");

	}

	@Override
	public <T> T update(T obj) throws AppException {
		throw new AppException("Should use the self service to update this entity.");
	}
}
