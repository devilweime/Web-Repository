package com.b2c.score.service;

import com.b2c.model.SysUser;

public interface IUserService {

	void register(SysUser user);

	SysUser checkUser(SysUser user);

	void updateState(Integer id);

}
