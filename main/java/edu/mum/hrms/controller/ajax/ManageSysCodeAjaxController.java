package edu.mum.hrms.controller.ajax;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.controller.LcfBaseAjaxController;
import edu.mum.hrms.model.SysCode;
import edu.mum.hrms.service.SysCodeService;
import edu.mum.hrms.validator.SysCodeValidator;

/**
 * ListSysCodeController
 * 
 * 
 * @author mz
 */
@Controller
@RequestMapping(value = "/ajax/sysCode")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ManageSysCodeAjaxController extends LcfBaseAjaxController{
	
	@Autowired 
	private SysCodeService sysCodeService;
    @InitBinder
    protected void initBinder(DataBinder  binder) {
        binder.setValidator(new SysCodeValidator());
    }
	
	@RequestMapping(value="/editSysCodeAjax.do")
    @ResponseBody
	public Map editSysCode(@Valid SysCode sysCode,Errors errors ,HttpServletRequest req) {
		Map rtnDataMap = new HashMap();
		try {
//			this.validateEditSysCode(newSysCode, rtnDataMap);
			if (errors.hasErrors()){
				   rtnDataMap.put(IS_SUCCESS, OP_RESULT_FALSE);
				   //or add more msg
				   //super.addActionError("more error msg", rtnDataMap);
				   super.addActionError("Failed to save the system code.", rtnDataMap);
				   super.handleFieldsErrorMsgMap(errors.getFieldErrors(),rtnDataMap);
		    	   return rtnDataMap;
		     }
			SysCode dbSysCode =sysCodeService.get(sysCode.getSysCodeId());
			dbSysCode.setTheKey(sysCode.getTheKey());
			dbSysCode.setTheValue(sysCode.getTheValue());
			dbSysCode.setStatus(sysCode.getStatus());
			dbSysCode.setSeq(sysCode.getSeq());
			dbSysCode.setSysCodeCategory(sysCode.getSysCodeCategory());
			dbSysCode.setSysLocale(sysCode.getSysLocale());
			sysCodeService.update(dbSysCode);
			//return it to front end
			rtnDataMap.put(dbSysCode.getSysCodeId(),dbSysCode);
			rtnDataMap.put(IS_SUCCESS, OP_RESULT_TRUE);
			rtnDataMap.put(OP_RETURN_MSG, "show more details for front end user.");
		} catch (Exception e) {
			if (e instanceof AppException) {
				super.handleException(e, rtnDataMap,req);
			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
				super.handleException(new AppException("aaa"), rtnDataMap,req);
			}
			super.addActionError("Failed to save the system code.", rtnDataMap);
			rtnDataMap.put(IS_SUCCESS, OP_RESULT_FALSE);
		}

		return rtnDataMap;
	}
}
