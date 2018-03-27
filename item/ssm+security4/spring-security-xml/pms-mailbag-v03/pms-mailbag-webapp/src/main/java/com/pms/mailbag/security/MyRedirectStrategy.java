package com.pms.mailbag.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.util.UrlUtils;

public class MyRedirectStrategy extends DefaultRedirectStrategy {

	protected final Log logger = LogFactory.getLog(getClass());

	private boolean contextRelative;

	/**
	 * 
	 * @param request
	 * @param response
	 * @param url
	 * @throws IOException
	 * 将重定向改写为返回重定向地址
	 * 
	 */
	public String returnRedirectUrl(HttpServletRequest request, HttpServletResponse response, String url) throws IOException {
		
		String redirectUrl = calculateRedirectUrl(request, url);
		redirectUrl = response.encodeRedirectURL(redirectUrl);

		if (logger.isDebugEnabled()) {
			logger.debug("Redirecting to '" + redirectUrl + "'");
		}

		return redirectUrl;
	}

	private String calculateRedirectUrl(HttpServletRequest request, String url) {
		String contextPath = request.getContextPath();
		
		if (!UrlUtils.isAbsoluteUrl(url)) {
			StringBuffer requestURL = request.getRequestURL();
			String domainUrl = requestURL.delete(requestURL.length() - request.getRequestURI().length(), requestURL.length()).toString();  
			
			if (contextRelative) {
				return domainUrl+url;
			} else {
				return domainUrl+contextPath + url;
			}
		}

		// Full URL, including http(s)://

		if (!contextRelative) {
			return url;
		}

		// Calculate the relative URL from the fully qualified URL, minus the
		// last
		// occurrence of the scheme and base context.
		url = url.substring(url.lastIndexOf("://") + 3); // strip off scheme
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}

		return url;
	}

	private String calculateRedirectUrl(String contextPath, String url) {
		if (!UrlUtils.isAbsoluteUrl(url)) {
			
			if (contextRelative) {
				return url;
			} else {
				return contextPath + url;
			}
		}

		// Full URL, including http(s)://

		if (!contextRelative) {
			return url;
		}

		// Calculate the relative URL from the fully qualified URL, minus the
		// last
		// occurrence of the scheme and base context.
		url = url.substring(url.lastIndexOf("://") + 3); // strip off scheme
		url = url.substring(url.indexOf(contextPath) + contextPath.length());

		if (url.length() > 1 && url.charAt(0) == '/') {
			url = url.substring(1);
		}

		return url;
	}
	
	
	
	
	/**
	 * If <tt>true</tt>, causes any redirection URLs to be calculated minus the
	 * protocol and context path (defaults to <tt>false</tt>).
	 */
	public void setContextRelative(boolean useRelativeContext) {
		this.contextRelative = useRelativeContext;
	}

}
