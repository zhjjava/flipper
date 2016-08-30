package edu.mum.hrms.controller.common;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.hrms.controller.LcfBaseController;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.util.menu.Menu;
import edu.mum.hrms.util.menu.MenusManager;


@Controller
@RequestMapping(value = "/layout/loadMenuPageAction.do")
public class MenuController extends LcfBaseController{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1887453475369547176L;
	
	public MenuController() {
		super();		
	}
    
	/**
	 * get menu list by current user
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String loadMenuByUser( Map<String, Object> modelMap, HttpSession session, HttpServletRequest req )
	{
		SysUser sessionUser = super.getSessionUser(session);
		List<String> operationList=sessionUser.getOperationItemList();
//		log.debug("getMenuByUser:"+operationList.size());
		String contextPath=req.getContextPath();
		Locale locale=req.getLocale(); //new Locale("en_US");
		try {
			List<Menu> menuList =MenusManager.getMenuByOperations(operationList,contextPath,locale);
			modelMap.put("loginName", sessionUser.getLoginName());
			modelMap.put("userName", sessionUser.getUserName());
			modelMap.put("menuList", menuList);
			System.out.println("menuList:" +menuList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return "common/menu";
	}

}
