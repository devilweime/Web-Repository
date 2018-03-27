package com.pms.mailbag.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.google.gson.Gson;

import org.springframework.security.web.savedrequest.DefaultSavedRequest;

public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	static final String SAVED_REQUEST = "SPRING_SECURITY_SAVED_REQUEST";
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		this.handle(request, response, authentication);
		this.clearAuthenticationAttributes(request);
	}

	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		Map<String, Object> resultMap = new HashMap<String, Object>();

		String targetUrl = determineTargetUrl(request, response);

		if (response.isCommitted()) {
			logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
			return;
		}
		String redirectUrl = request.getHeader("Referer"); 
		if(redirectUrl == null || "".equals(redirectUrl)){
			redirectUrl= request.getContextPath()+"/";
		}
		resultMap.put("success", true);
		resultMap.put("redirectUrl",redirectUrl);
		resultMap.put("message", "");
		Gson gson = new Gson();
		String json = gson.toJson(resultMap);
		response.getWriter().write(json);
		response.getWriter().flush();

	}
}
