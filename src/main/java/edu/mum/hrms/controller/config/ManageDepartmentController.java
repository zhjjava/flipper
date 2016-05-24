package edu.mum.hrms.controller.config;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


import edu.mum.core.dao.Page;
import edu.mum.core.exception.AppException;
import edu.mum.core.web.PageReq;
import edu.mum.core.web.QueryReq;
import edu.mum.hrms.controller.LcfBaseController;
import edu.mum.hrms.data.QueryFormData;
import edu.mum.hrms.model.SysDepartment;
import edu.mum.hrms.service.DepartmentService;


@Controller
@RequestMapping(value = "/config/")
public class ManageDepartmentController extends LcfBaseController {

	// will be invoked automatically when user invokes every method in this
	// controller
	// so it acts a initialization method
	@ModelAttribute("queryFormData")
	public QueryFormData initQueryFormData(QueryFormData queryFormData) {
		return new QueryFormData();
	}

	@Autowired
	private DepartmentService departmentService;
	@RequestMapping(value = "/listDepartment.do")
	public String queryDepartment(Model modelMap,
			@ModelAttribute QueryFormData queryFormData,
			BindingResult errorResult, QueryReq queryReq, PageReq pageReq) {
		try {
			Page page = departmentService
					.find(queryFormData, queryReq, pageReq);
			modelMap.addAttribute("pageData", page);

		} catch (Exception e) {
            e.printStackTrace();
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else {
				super.handleException(new AppException(99999), errorResult);
			}
		}

		return "config/listDepartment";
	}

	@RequestMapping(value = "/addDepartment.do")
	public String add(Model modelMap, @ModelAttribute SysDepartment department,
			BindingResult errorResult, HttpSession session) {

		if(errorResult.hasErrors()){
			return "config/listDepartment";
		}

		department.setCreateTime(new Date());
		department.setUpdateTime(new Date());

		department.setDepartState(1);
		try {
			departmentService.save(department);
			String msg = "Succeeded to add a department.";
			modelMap.addAttribute("msg", msg);
			log.debug("Succeeded to add a department " + department.getDepartName());
		} catch (AppException e) {
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else {// to use a pre-defined error code regarding current
					// business to report current error for end user, ex: 99999
				super.handleException(new AppException(99999), errorResult);
			}
		}

		return queryDepartment(modelMap, null, errorResult, null, new PageReq());
	}

	@RequestMapping(value = "/updateDepartment.do")
	public String update(Model modelMap, @ModelAttribute SysDepartment department,
			BindingResult errorResult,HttpSession session) {
		if(errorResult.hasErrors()){
			return "config/listDepartment";
		}
		String msg = null;
		QueryFormData queryFormData = new QueryFormData();
		try {
			SysDepartment oriDepartment = departmentService.get(department
					.getDepartId());
			oriDepartment.setDepartName(department.getDepartName());
			oriDepartment.setDepartNum(department.getDepartNum());
			oriDepartment.setDepartMajor(department.getDepartMajor());
			oriDepartment.setUpdateTime(new Date());

//			department.setUpdateId((getSessionUserId(session)));//

			departmentService.update(oriDepartment);

			msg = "Succeeded to update a department.";
			modelMap.addAttribute("msg", msg);
			modelMap.addAttribute(queryFormData);
			log.debug("Succeeded to update the department " + oriDepartment.getDepartName());
		} catch (AppException e) {
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else {// to use a pre-defined error code regarding current
					// business to report current error for end user, ex: 99999
				super.handleException(new AppException(99999), errorResult);
			}
		}

		return queryDepartment(modelMap, null, errorResult, null, new PageReq());
	}

//	@RequestMapping(value="/.do")
	public String view(Model model,long rid){
		try {
			SysDepartment department=departmentService.get(rid);
			model.addAttribute("department", department);
		} catch (AppException e) {
//			if (e instanceof AppException) {
//				super.handleException(e, errorResult);
//			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
//				super.handleException(new AppException(99999), errorResult);
//			}
		}


		return "config/listDepartment";
	}

	@RequestMapping(value = "/deleteDepartment.do")
	public String delete(Model modelMap,Long rId,BindingResult errorResult){
		try {
			if(rId==null){
				errorResult.reject(null,"Expected a valid departId.");
				return queryDepartment(modelMap, new QueryFormData(),errorResult, new QueryReq(),new PageReq());
			}
			SysDepartment department=departmentService.get(rId);
			department.setDepartState(0);
			departmentService.update(department);
//			departmentService.removeById(rId);
		} catch (Exception e) {
			if (e instanceof AppException) {
				super.handleException(e, errorResult);
			} else{//to use a pre-defined error code regarding current business to report current error for end user, ex: 99999
				super.handleException(new AppException(99999), errorResult);
			}
			return queryDepartment(modelMap, new QueryFormData(), errorResult, new QueryReq(),new PageReq());
		}
		modelMap.addAttribute(RTN_MSG_CODE, MSG_DELETE1_SUCCESS);
		modelMap.addAttribute(RTN_MSG_PARAMS, rId);
		return queryDepartment(modelMap, new QueryFormData(),errorResult, new QueryReq(),new PageReq());

	}



}

