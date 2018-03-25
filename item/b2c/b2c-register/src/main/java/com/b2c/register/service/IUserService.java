package com.b2c.register.service;

import com.b2c.model.SysUser;

public interface IUserService {

	SysUser register(SysUser user);

	SysUser checkUser(SysUser user);

	String updateState(Integer id, String uuid);

}
