package edu.mum.hrms.component.configuration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.service.UserService;
import edu.mum.hrms.util.AppConstants;

@Component
public class HrmsAuthenticationSuccessHandler implements    AuthenticationSuccessHandler  {	
	
	@Autowired
	private UserService userService;
	
	@Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
            HttpServletResponse response, Authentication authentication) 
            throws ServletException, IOException {
        
		UserDetails userDetails=(UserDetails) authentication.getPrincipal();		
//		
//		Authentication auth = new UsernamePasswordAuthenticationToken(authentication.getPrincipal(), 
//				authentication.getCredentials(), buildUserAuthority(hrService.findEmployeeRoleByEmployee(userDetails.getUsername())));
//		SecurityContextHolder.getContext().setAuthentication(auth);
//       	super.onAuthenticationSuccess(request, response, authentication);
		

		try {
			SysUser currentUser;
			System.out.println("userDetails.getUsername():"+userDetails.getUsername());
			currentUser = userService.getLoginUser(userDetails.getUsername());
			request.getSession().setAttribute(AppConstants.SYS_USER_KEY_IN_SESSION, currentUser);

		} catch (AppException e) {
			e.printStackTrace();
		}

		response.sendRedirect(request.getContextPath() + "/index.do");
        
    }
	
	
	
}
