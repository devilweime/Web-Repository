package com.b2c.register.service.impl;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.b2c.commons.utils.MD5Utils;
import com.b2c.mapper.SysUserMapper;
import com.b2c.model.SysUser;
import com.b2c.model.SysUserExample;
import com.b2c.model.SysUserExample.Criteria;
import com.b2c.register.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private SysUserMapper userMapper;

	@Override
	public SysUser register(SysUser user) {
		
		// 设置flag、state
		user.setFlag((byte) 1);
		user.setState((byte) 0);
		user.setActivateUuid(UUID.randomUUID().toString());

		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<SysUser> list = userMapper.selectByExample(example);
		SysUser oldUser = null;
		if (list.size() != 0) {
			oldUser = list.get(0);
		}
		if (oldUser == null) {
			String encrypt = MD5Utils.encrypt(user.getUsername(), user.getPassword());
			user.setPassword(encrypt);
			userMapper.insert(user);
		}
		return user;
	}

	@Override
	public SysUser checkUser(SysUser user) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<SysUser> list = userMapper.selectByExample(example);
		SysUser newUser = list.get(0);
		if (newUser != null) {
			String encrypt = MD5Utils.encrypt(user.getUsername(), user.getPassword());
			if (encrypt.equals(newUser.getPassword())) {
				return newUser;
			}
		}
		return null;
	}

	@Override
	public String updateState(Integer id, String uuid) {

		SysUser user = userMapper.selectByPrimaryKey(id);
		try {
			if (user.getActivateUuid().equals(uuid)) {
				user.setState((byte) 1);
				SysUserExample example = new SysUserExample();
				Criteria criteria = example.createCriteria();
				criteria.andIdEqualTo(id);
				userMapper.updateByExampleSelective(user, example);
				return "success";
			} else {
				return "error";
			}
		} catch (Exception e) {
			return "error";
		}

	}

}
