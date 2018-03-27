package com.pms.mailbag.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.mailbag.dao.mapper.AuthExtendMapper;
import com.pms.mailbag.dao.model.Authority;
import com.pms.mailbag.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService{

	@Autowired
	private AuthExtendMapper authExtendMapper;
	
	@Override
	public List<Authority> getAuthorityByUserId(String userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		return authExtendMapper.getAuthorityByUserId(paramMap);
	}
	
}
