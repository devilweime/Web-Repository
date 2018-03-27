package com.pms.mailbag.service;

import java.util.List;

import com.pms.mailbag.dao.model.Authority;

public interface AuthService {

	List<Authority> getAuthorityByUserId(String username);
}
