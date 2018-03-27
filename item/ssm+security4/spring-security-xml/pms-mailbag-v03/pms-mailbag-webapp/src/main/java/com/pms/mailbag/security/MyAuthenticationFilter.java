package com.pms.mailbag.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.pms.mailbag.dao.mapper.UserExtendMapper;
import com.pms.mailbag.dao.model.CUserLoginRecord;
import com.pms.mailbag.dao.model.User;
import com.pms.mailbag.utils.Des3;

public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	private static final String USERNAME = "username";
	private static final String PASSWORD = "password";

	@Autowired
	private UserExtendMapper userExtendMapper;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
		}

		String username = obtainUsername(request).trim();
		String password = obtainPassword(request).trim();

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", username);
		User loginUser = userExtendMapper.getUserInfoByUsername(paramMap);
		if (loginUser == null) {
			throw new UsernameNotFoundException("找不到该用户:" + username);
		}

		if (!Des3.encrypt(password).equals(loginUser.getPassword())) {
			throw new BadCredentialsException("密码不正确");
		}

		String userId = loginUser.getUserId();
		Date date = new Date();

		CUserLoginRecord userLoginRecord = new CUserLoginRecord();
		userLoginRecord.setUserId(userId);
		userLoginRecord.setLoginAddress(getIpAddr(request));
		userLoginRecord.setLoginTime(date);
		userLoginRecord.setCreateBy(userId);
		userLoginRecord.setCreateTime(date);
		userLoginRecord.setUpdateBy(userId);
		userLoginRecord.setUpdateTime(date);
		userLoginRecord.setLoginStatus("1");
		userExtendMapper.insertCUserLoginRecordSelective(userLoginRecord);
		

		HttpSession session = request.getSession();
		// TODO cookie
		// TODO 用户登录记录
		session.setAttribute("loginUser", loginUser);

		UsernamePasswordAuthenticationToken authRequest = null;
		// 实现验证
		authRequest = new UsernamePasswordAuthenticationToken(username, password);
		// 允许设置用户详细属性
		setDetails(request, authRequest);
		// 运行
		return this.getAuthenticationManager().authenticate(authRequest);

	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		Object obj = request.getParameter(USERNAME);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		Object obj = request.getParameter(PASSWORD);
		return null == obj ? "" : obj.toString();
	}

	@Override
	protected void setDetails(HttpServletRequest request, UsernamePasswordAuthenticationToken authRequest) {
		super.setDetails(request, authRequest);
	}

	/**
	 * 获取IP地址
	 * 
	 * @param request
	 * @return
	 */
	private String getIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}