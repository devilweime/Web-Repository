package com.b2c.passport.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.commons.utils.MD5Utils;
import com.b2c.mapper.SysUserMapper;
import com.b2c.model.SysUser;
import com.b2c.model.SysUserExample;
import com.b2c.model.SysUserExample.Criteria;
import com.b2c.passport.service.IPassportService;
@Service
public class PassportServiceImpl implements IPassportService{

	@Autowired
	private SysUserMapper userMapper;
	
	@Override
	public SysUser checkIsExist(SysUser user) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<SysUser> list = userMapper.selectByExample(example);
		if (list!=null && !list.isEmpty()) {
			SysUser newUser = list.get(0);
			String encrypt = MD5Utils.encrypt(user.getUsername(), user.getPassword());
			if (newUser.getPassword().equals(encrypt)) {
				return newUser;
			}
		}
		return null;
	}

}
