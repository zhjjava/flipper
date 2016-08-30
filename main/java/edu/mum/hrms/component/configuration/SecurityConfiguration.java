//package edu.mum.hrms.component.configuration;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//
////	@Autowired
////	@Qualifier("customUserDetailsService")
////	UserDetailsService userDetailsService;
//
//	@Autowired
//	HrmsAuthenticationSuccessHandler hrmsAuthenticationSuccessHandler;
//	
////	
////	@Autowired
////	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
////		auth.userDetailsService(userDetailsService);
////	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//	  http.authorizeRequests()
//	  	//.antMatchers("/", "/home").permitAll()
//	  	.antMatchers("/", "/home").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_STAFF') and hasRole('ROLE_MANAGER')")
//	  	.antMatchers("/config/**").access("hasRole('ROLE_ADMIN')")
//	  	.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
//	  	//.and().formLogin().loginPage("/login")
//	  	.and().formLogin().loginPage("/login").successHandler(hrmsAuthenticationSuccessHandler)
//	  	.usernameParameter("username").passwordParameter("password")
//	  	.and().csrf()
//	  	.and().exceptionHandling().accessDeniedPage("/errors/403.do");
//	}
//
//}
