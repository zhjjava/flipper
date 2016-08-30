package edu.mum.hrms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.core.exception.AppException;
import edu.mum.hrms.model.Authority;
import edu.mum.hrms.model.SysUser;
import edu.mum.hrms.service.UserService;

@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserService userService;

    @Autowired
    public void setUserService(UserService userService) { 
        this.userService = userService;
    }
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
		SysUser sysUser;
		try {
			sysUser = userService.getLoginUser(loginName);
			System.out.println("User : " + sysUser);
			if (sysUser == null) {
				System.out.println("User not found");
				throw new UsernameNotFoundException("Username not found");
			}
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();   		
	  		String encodedPassword = passwordEncoder.encode(sysUser.getPassword());
	  		
			return new org.springframework.security.core.userdetails.User(sysUser.getLoginName(), encodedPassword,
					(1 == sysUser.getStatus()), true, true, true, getGrantedAuthorities(sysUser));
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
	}

	private List<GrantedAuthority> getGrantedAuthorities(SysUser sysUser) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		List<Authority> authorityListOfSysUser = sysUser.getUserCredentials().getAuthority();
		for (Authority auth : authorityListOfSysUser) {
			System.out.println("Authority: " + auth);
			authorities.add(new SimpleGrantedAuthority(auth.getAuthority()));
		}
		System.out.print("authorities :" + authorities);
		return authorities;
	}

}
