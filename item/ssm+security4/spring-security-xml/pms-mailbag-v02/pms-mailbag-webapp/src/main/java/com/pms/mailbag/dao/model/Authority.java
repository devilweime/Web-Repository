package com.pms.mailbag.dao.model;

public class Authority {

	private String authId;
	
	private String authName;
	
	private String parentAuthId;
	
	private String authSort;

	public String getAuthId() {
		return authId;
	}

	public void setAuthId(String authId) {
		this.authId = authId;
	}

	public String getAuthName() {
		return authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}

	public String getParentAuthId() {
		return parentAuthId;
	}

	public void setParentAuthId(String parentAuthId) {
		this.parentAuthId = parentAuthId;
	}

	public String getAuthSort() {
		return authSort;
	}

	public void setAuthSort(String authSort) {
		this.authSort = authSort;
	}
}
