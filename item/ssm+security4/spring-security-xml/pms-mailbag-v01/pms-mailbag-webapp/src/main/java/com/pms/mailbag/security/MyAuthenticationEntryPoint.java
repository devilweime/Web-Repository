package com.pms.mailbag.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

import com.google.gson.Gson;

public class MyAuthenticationEntryPoint extends LoginUrlAuthenticationEntryPoint {

	public MyAuthenticationEntryPoint(String loginFormUrl) {
		super(loginFormUrl);
	}

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {

		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if ("XMLHttpRequest".equals(httpRequest.getHeader("X-Requested-With"))) {
			
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if(authException!=null){
				resultMap.put("success", false);
				resultMap.put("message", authException.getMessage());
				response.setHeader("Content-Type", "application/json;charset=UTF-8");
				Gson gson = new Gson();
				String json = gson.toJson(resultMap);
				response.getWriter().write(json);
				response.getWriter().flush();
			}
		} else {
			super.commence(request, response, authException);
		}

	}

}
