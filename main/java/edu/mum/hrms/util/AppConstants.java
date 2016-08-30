/*
 * @(#)AppConstants.java	2015-6-2下午03:21:42
 * Copyright 2015  lc All rights reserved.
 */
package edu.mum.hrms.util;

import edu.mum.hrms.listener.ApplicationListener;


/**
 *
 * 类<strong>AppConstants.java</strong>{应用系统常量定义}
 *
 * @author: mz
 * @version: 1.0	Date: 2015-6-2 下午03:21:42
 */
public class AppConstants {

	//for common
	public static final int STATUS_VALID_1=1;

	public static final int STATUS_INVALID_0=0;

	public static final int STATUS_ENABLED_1=1;

	public static final int STATUS_DISABLED_0=0;
	
	public static final int IS_DELETED_1=1;
	public static final int IS_DELETED_0=0;
	
	public static final String STATUS_ENABLED_STR_1="1";
	public static final String STATUS_DISABLED_STR_0="0";

	public static final String SYS_LANGUAGE_CN="zh_CN"; //国际化中文
	public static final String SYS_LANGUAGE_EN="en_US"; //国际化英文
	

	public static final String SYS_USER_KEY_IN_SESSION="sessionSysUser";
	
	public static final String EXCEL_TMPL_APPLIED_TRUE="true"; //
	public static final String EXCEL_TMPL_APPLIED_FALSE="false"; //
	
	public static final String EXCEL_ROW_DATA_LIST="excelRowDataList";
	public static final String EXCEL_PROPERTY_NAMES="excelPropertyNames";
	public static final String EXCEL_COLUMN_HEADER_NAMES="excelColumnHeaderNames";
	
	public static final String EXCEL_OTHER_CELL_DATA_MAP="excelOtherCellDataMap";
	public static final String EXCEL_DATA_AREA_START_CELL_NO="excelDataAreaStartCellNo";
	
	//SYS_CODE,roleType
	public static final String SYS_ROLE_TYPE_1001="1001"; //普通角色
	public static final String SYS_ROLE_TYPE_2001="2001"; //特殊角色1,呼叫中心业务管理员,只要为某个角色设定了该属性，则系统可以为该角色配置能管理的签证中心
	public static final String SYS_ROLE_TYPE_3001="3001"; //特殊角色2,待定,暂未使用
	
	public static final String PrivateFileName=ApplicationListener.REAL_PATH+"/WEB-INF/"+"lancangPrivate.dat";
	public static final String PublicFileName=ApplicationListener.REAL_PATH+"/WEB-INF/"+"lancangPublic.dat";
	public static final String SignatureFileName=ApplicationListener.REAL_PATH+"/WEB-INF/"+"lancangSinged.dat";	
	
	public static final String RSA_SEED="lancang";
	public static final String QUEUE_VERIFY_ALGORITHM="RSA";
	public static final long QUEUE_VERIFY_RANDOM=1903;	
	
	//authticate data
	public static final String AUTH_OBJECT = "authObject";
	public static final String PK_FIELD_NAME_IN_PARAS = "pkFieldNameInParas";
	public static final String CLASS_TYPE = "classType";
	public static final String AUTH_FIELDS = "authFields";
	public static final String DEFAULT_CLASS_PACKAGE = "edu.mum.hrms.model.";
	public static final String AUTH_TYPE = "authType";
	public static final String AUTH_TYPE_OWNER = "owner";
	public static final String AUTH_TYPE_VISACENTER = "visacenter";
	public static final String AUTH_TYPE_SELF = "self";
	public static final String USER_ID_FIELD_NAME = "userIdFieldName";
	public static final String VC_ID_FIELD_NAME = "vcIdFieldName";
	public static final String NULL_VALUE="null";	
	
}
