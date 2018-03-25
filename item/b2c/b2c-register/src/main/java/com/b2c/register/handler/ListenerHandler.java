package com.b2c.register.handler;

import javax.servlet.http.HttpSession;


public class ListenerHandler {
	private HttpSession session;
	
	public void listen(String msg) {
		System.out.println(msg);
		getSession().setAttribute("code", msg);
		getSession().setMaxInactiveInterval(60 * 10);
	}

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}
}
