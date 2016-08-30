package edu.mum.hrms.controller.ajax;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.controller.LcfBaseAjaxController;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.service.DepartmentService;

/**
 * ListSysCodeController
 * 
 * 
 */
@Controller
@RequestMapping(value = "/ajax/sysCode")
@SuppressWarnings({ "unchecked", "rawtypes" })
public class ManageDepartmentAjaxController extends LcfBaseAjaxController{
	
	@Autowired 
	private DepartmentService departmentService;

	@RequestMapping(value="/editDepartmentAjax.do")
    @ResponseBody
	public Map editDepartment(@Valid SysDepartment newDepartment,Errors errors, HttpServletRequest req) {
		Map rtnDataMap = new HashMap();
		try {
			if (errors.hasErrors()){
				   rtnDataMap.put(IS_SUCCESS, OP_RESULT_FALSE);
				   //or add more msg
				   //super.addActionError("more error msg", rtnDataMap);
				   super.addActionError("Failed to update the department.", rtnDataMap);
				   super.handleFieldsErrorMsgMap(errors.getFieldErrors(),rtnDataMap);
		    	   return rtnDataMap;
		     }
			
			rtnDataMap.put(IS_SUCCESS, OP_RESULT_TRUE);
			rtnDataMap.put(OP_RETURN_MSG, "show more details for front end user.");
			SysDepartment dbDepartment =departmentService.get(newDepartment.getDepartId());
			dbDepartment.setDepartName(newDepartment.getDepartName());
			dbDepartment.setDepartNum(newDepartment.getDepartNum());
			//dbDepartment.setDepartMajor(newDepartment.getDepartMajor());
			dbDepartment.setUpdateTime(new Date());
			departmentService.update(dbDepartment);
			//return it to front end
			rtnDataMap.put(dbDepartment.getDepartId(),dbDepartment);
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof AppException) {
				super.handleException(e, rtnDataMap,req);
			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
				super.handleException(new AppException(1000), rtnDataMap,req);
			}
			rtnDataMap.put(IS_SUCCESS, OP_RESULT_FALSE);
		}

		return rtnDataMap;
	}
}
