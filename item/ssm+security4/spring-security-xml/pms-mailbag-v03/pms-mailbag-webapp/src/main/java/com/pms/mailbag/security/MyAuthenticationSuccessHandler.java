package com.pms.mailbag.security;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;

public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

	private MyRedirectStrategy redirectStrategy = new MyRedirectStrategy();
	
	protected final Log logger = LogFactory.getLog(this.getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();


	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		try {
			String redirectUrl = null;
			SavedRequest savedRequest = requestCache.getRequest(request, response);

			if (savedRequest == null) {//不存在请求缓存
				/*super.onAuthenticationSuccess(request, response, authentication);

				return;*/
				
				redirectUrl = redirectStrategy.returnRedirectUrl(request, response,determineTargetUrl(request, response));
				
				
				
			}else{
				
				String targetUrlParameter = getTargetUrlParameter();
				if (isAlwaysUseDefaultTargetUrl() || (targetUrlParameter != null && StringUtils.hasText(request.getParameter(targetUrlParameter)))) {
					requestCache.removeRequest(request, response);
					super.onAuthenticationSuccess(request, response, authentication);

					return;
				}

				clearAuthenticationAttributes(request);

				// Use the DefaultSavedRequest URL
				String targetUrl = savedRequest.getRedirectUrl();
				logger.debug("Redirecting to DefaultSavedRequest Url: " + targetUrl);
				redirectUrl = redirectStrategy.returnRedirectUrl(request, response,targetUrl);
				
			}
			
			resultMap.put("success", true);
			resultMap.put("redirectUrl",redirectUrl);
		} catch (Exception e) {
			logger.error(e);
			resultMap.put("success", false);
			resultMap.put("message", e.getMessage());
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(resultMap);
		response.getWriter().write(json);
		response.getWriter().flush();
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}

	
	
	
}
