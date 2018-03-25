package com.b2c.login.service.impl;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.b2c.commons.utils.MD5Utils;
import com.b2c.login.service.IUserService;
import com.b2c.mapper.SysUserMapper;
import com.b2c.model.SysUser;
import com.b2c.model.SysUserExample;
import com.b2c.model.SysUserExample.Criteria;
import com.google.gson.Gson;

@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private RabbitTemplate rabbitTemplate;
	
	@Override
	public void register(SysUser user) {
		//设置flag、state
		user.setFlag((byte)1);
		user.setState((byte)0);
		
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<SysUser> list = userMapper.selectByExample(example );
		SysUser oldUser =null;
		if(list.size()!=0){
			oldUser = list.get(0);
		}
		if(oldUser==null){
			String encrypt = MD5Utils.encrypt(user.getUsername(), user.getPassword());
			user.setPassword(encrypt);
			userMapper.insert(user);
			//上传到mq
			Gson gson = new Gson();
			String json = gson.toJson(user);
			rabbitTemplate.convertAndSend(json);
		}
	}

	@Override
	public SysUser checkUser(SysUser user) {
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andUsernameEqualTo(user.getUsername());
		List<SysUser> list = userMapper.selectByExample(example);
		SysUser newUser = list.get(0);
		if (newUser!=null) {
			String encrypt = MD5Utils.encrypt(user.getUsername(), user.getPassword());
			if (encrypt.equals(newUser.getPassword())) {
				return newUser;
			}
		}
		return null;
	}

	@Override
	public void updateState(Integer id) {
		SysUser user = new SysUser();
		user.setState((byte) 1);
		SysUserExample example = new SysUserExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(id);
		userMapper.updateByExampleSelective(user, example);
	}

}
