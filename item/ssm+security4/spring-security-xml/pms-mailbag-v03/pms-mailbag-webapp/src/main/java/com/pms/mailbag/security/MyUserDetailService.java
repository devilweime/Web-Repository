package com.pms.mailbag.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.google.gson.Gson;
import com.pms.mailbag.dao.mapper.UserExtendMapper;
import com.pms.mailbag.dao.model.Authority;
import com.pms.mailbag.service.AuthService;

public class MyUserDetailService implements UserDetailsService {

	@Autowired
	private UserExtendMapper userExtendMapper;
	
	@Autowired
	private AuthService authService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", username);
		com.pms.mailbag.dao.model.User loginUser = userExtendMapper.getUserInfoByUsername(paramMap);
		if (loginUser == null) {
			throw new UsernameNotFoundException("找不到该用户:" + username);
		}
		
		Collection<GrantedAuthority> auths = new ArrayList<GrantedAuthority>();
		if ("1".equals(loginUser.getSupperUserFlag())) {// 管理员拥有所有的权限
			SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_ADMIN");
			auths.add(auth);
		} else {
			List<Authority> authorityList = authService.getAuthorityByUserId(loginUser.getUserId());
			for (Authority authority : authorityList) {
				if("mailbagreceive".equals(authority.getAuthId())){
					SimpleGrantedAuthority auth = new SimpleGrantedAuthority("ROLE_mailbagreceive");
					auths.add(auth);
				}
			}
		}

		User user = new User(loginUser.getUsername(), loginUser.getPassword(), true, true, true, true, auths);
		return user;
	}
}
