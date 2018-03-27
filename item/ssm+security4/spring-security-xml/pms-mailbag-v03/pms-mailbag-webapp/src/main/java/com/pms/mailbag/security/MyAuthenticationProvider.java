package com.pms.mailbag.security;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.pms.mailbag.utils.Des3;

public class MyAuthenticationProvider extends  AbstractUserDetailsAuthenticationProvider{
	
	private UserDetailsService userDetailsService;
	
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		String password  = authentication.getCredentials().toString();
		
		if(!Des3.encrypt(password).equals(userDetails.getPassword())){
			throw new BadCredentialsException("密码不正确");
		}
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		
		UserDetails userDetails = getUserDetailsService().loadUserByUsername(username);
		
		return userDetails;
	}

	public UserDetailsService getUserDetailsService() {
		return userDetailsService;
	}

	public void setUserDetailsService(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	

}
