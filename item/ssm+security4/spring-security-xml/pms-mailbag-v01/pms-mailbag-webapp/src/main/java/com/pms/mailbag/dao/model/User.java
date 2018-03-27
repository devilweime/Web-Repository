package com.pms.mailbag.dao.model;

public class User {

	private String userId;
	
	private String username;
	
	private String password;
	
	private String agentCompanyId;
	
	private String agentCompanyName;
	
	private String agentCompanyCode;
	
	private String supperUserFlag;
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAgentCompanyId() {
		return agentCompanyId;
	}

	public void setAgentCompanyId(String agentCompanyId) {
		this.agentCompanyId = agentCompanyId;
	}

	public String getAgentCompanyName() {
		return agentCompanyName;
	}

	public void setAgentCompanyName(String agentCompanyName) {
		this.agentCompanyName = agentCompanyName;
	}

	public String getAgentCompanyCode() {
		return agentCompanyCode;
	}

	public void setAgentCompanyCode(String agentCompanyCode) {
		this.agentCompanyCode = agentCompanyCode;
	}

	public String getSupperUserFlag() {
		return supperUserFlag;
	}

	public void setSupperUserFlag(String supperUserFlag) {
		this.supperUserFlag = supperUserFlag;
	}

	
}
