package edu.mum.hrms.controller.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.util.KeyValueBean;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.controller.LcfBaseController;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysCodeCategory;
import edu.mum.hrms.service.SysCodeService;
import edu.mum.hrms.service.SysLocaleService;

/**
 * ListSysCodeController
 *
 *
 * @author mz
 */
@Controller
@RequestMapping(value = "/config")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ListSysCodeController extends LcfBaseController{

	//will be invoked automatically when user invokes every method in this controller
	//so it acts a initialization method
	@ModelAttribute("queryFormData")
	public QueryFormData initQueryFormData() {
		QueryFormData aQueryFormData = new QueryFormData();
		List<KeyValueBean> list = new ArrayList<KeyValueBean>();
		list.add(new KeyValueBean("Enabled","1"));
		list.add(new KeyValueBean("Disabled","0"));
		aQueryFormData.setStatusList(list);
		//aQueryFormData.setField2("0");
	    return aQueryFormData;
	}


	@Autowired
	private SysCodeService sysCodeService;
	@Autowired
	private SysLocaleService sysLocaleService;

	public ListSysCodeController() {
		super();
	}


	@RequestMapping(value="/preListSysCode.do")
	public String preQuerySysCode( Map modelMap) {
		List<KeyValueBean> list = new ArrayList<KeyValueBean>();
		list.add(new KeyValueBean("Enabled","1"));
		list.add(new KeyValueBean("Disabled","0"));
		modelMap.put("statusList2", list);

//		<property name="prefix" value="/WEB-INF/jsp/"/>
//		<property name="suffix" value=".jsp"/>
//		/WEB-INF/jsp/config/listSysCode.jsp
		return "config/listSysCode";
	}


	@RequestMapping(value="/listSysCode.do")
	public String querySysCode(Map modelMap,QueryFormData queryFormData2,Errors errorResult, QueryReq queryReq, PageReq pageReq) {
		try {
			List<KeyValueBean> list = new ArrayList<KeyValueBean>();
			list.add(new KeyValueBean("Enabled","1"));
			list.add(new KeyValueBean("Disabled","0"));
			modelMap.put("statusList2", list);

			Page page = sysCodeService.find(queryFormData2, queryReq, pageReq);
			modelMap.put("pageData", page);
			//init SysLocale
			List<KeyValueBean> sysLocaleList = sysLocaleService.listSysLocales();
			//init sysCategory
			List<SysCodeCategory> sysCodeCategoryList = sysCodeService.listSysCategoryList();

			modelMap.put("sysLocaleList", sysLocaleList);
			modelMap.put("sysCodeCategoryList", sysCodeCategoryList);
		} catch (Exception e) {
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
				super.handleException(new AppException(99999), errorResult);
			}
		}

		return "config/listSysCode";
	}

	@RequestMapping(value="/deleteSysCode.do")
//	@PreAuthorize("hasRole('ROLE_ADMIN')") 
	//@Secured("ROLE_ADMIN")
	public String deleteSysCode( Map modelMap,Long rId,QueryFormData queryFormData, Errors errorResult) {
		try {
			if(rId==null){
				errorResult.reject(null,"Expected a valid sysCodeId.");
				return querySysCode(modelMap, new QueryFormData(),errorResult, new QueryReq(),new PageReq());
			}
			sysCodeService.removeById(rId);
		} catch(AuthenticationCredentialsNotFoundException e1){
			e1.printStackTrace();
			super.addActionError("No Authorization.", errorResult);
			return querySysCode(modelMap, new QueryFormData(), errorResult, new QueryReq(),new PageReq());
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
				super.handleException(new AppException(99999), errorResult);
			}
			return querySysCode(modelMap, new QueryFormData(), errorResult, new QueryReq(),new PageReq());
		}
//		modelMap.put(RTN_MSG_CODE, MSG_DELETE1_SUCCESS);
//		modelMap.put(RTN_MSG_PARAMS, rId);
		super.addActionMsg("Succeeded to delete the syscode", modelMap);
//		super.addActionError(errorMsg, errorResult);
		return querySysCode(modelMap, new QueryFormData(),errorResult, new QueryReq(),new PageReq());
	}
}
