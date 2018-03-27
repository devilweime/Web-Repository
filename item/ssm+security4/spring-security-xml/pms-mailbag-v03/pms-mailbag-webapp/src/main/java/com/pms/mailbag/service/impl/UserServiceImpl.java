package com.pms.mailbag.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.pms.mailbag.dao.mapper.UserExtendMapper;
import com.pms.mailbag.dao.model.User;
import com.pms.mailbag.exception.BusinessException;
import com.pms.mailbag.exception.SystemException;
import com.pms.mailbag.messageAndCode.extraction.BaseEnCode;
import com.pms.mailbag.messageAndCode.extraction.SystemEnCode;
import com.pms.mailbag.response.BaseResponse;
import com.pms.mailbag.service.UserService;
import com.pms.mailbag.utils.Des3;
import com.pms.mailbag.utils.ResponseUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserExtendMapper userExtendMapper;

	@Override
	public User checkUser(User user) {
		User loginUser = null;
		try {
			if (user.getUserId() != null) {
				loginUser = getUserInfoByUserId(user);
			}

			if (user.getUsername() != null) {
				loginUser = getUserInfoByUsername(user);
			}

			if (loginUser == null) {
				throw new SystemException(SystemEnCode.USERNAME_DOES_NOT_EXIST);
			}
			String encryptPassword = Des3.encrypt(user.getPassword());
			if (!encryptPassword.equals(loginUser.getPassword())) {
				throw new SystemException(SystemEnCode.PASSWORD_IS_NOT_INCORRECT);
			}
			loginUser.setPassword(null);

		} catch (Exception e) {
			e.printStackTrace();

		}
		loginUser.setSupperUserFlag(null);
		return loginUser;
	}

	@Override
	public String getUserInfo(User user) {

		BaseResponse response = null;
		try {
			User loginUser = checkUser(user);
			response = ResponseUtils.getResponse(loginUser);

		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();

		return gson.toJson(response);
	}

	@Override
	public String updatePassword(String username, String oldPassword, String newPassword) {
		BaseResponse response = null;
		try {
			User user = new User();
			user.setUsername(username);
			user.setPassword(oldPassword);
			User loginUser = checkUser(user);
			int length = newPassword.length();
			if(length<6 || length>12){
				throw new SystemException(SystemEnCode.NONSTANDARD_PASSWORD);
			}
			if (loginUser == null) {
				throw new SystemException(SystemEnCode.USERNAME_OR_PASSWORD_IS_NOT_INCORRECT);
			}

			Map<String, Object> paramMap = new HashMap<String, Object>();
			paramMap.put("userId", user.getUserId());
			paramMap.put("newPassword", Des3.encrypt(newPassword));
			userExtendMapper.getUserInfoByUserId(paramMap);
			response = ResponseUtils.getResponse("", BaseEnCode.OPRATION_SUCCEESS);
		} catch (Exception e) {
			e.printStackTrace();
			response = ResponseUtils.getResponse(e);
		}
		Gson gson = new Gson();
		return gson.toJson(response);
	}

	private User getUserInfoByUsername(User user) {

		String username = user.getUsername().trim();
		String password = user.getPassword().trim();
		if (username == null && "".equals(username)) {
			throw new SystemException(SystemEnCode.USERNAME_CAN_NOT_BE_EMPTY);
		}
		if (password == null && "".equals(password)) {
			throw new SystemException(SystemEnCode.PASSWORD_CAN_NOT_BE_EMPTY);
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("username", user.getUsername());
		User loginUser = userExtendMapper.getUserInfoByUsername(paramMap);

		return loginUser;
	}

	private User getUserInfoByUserId(User user) {

		String userId = user.getUserId();
		String password = user.getPassword().trim();
		if (userId == null && "".equals(userId)) {
			throw new SystemException(SystemEnCode.USERID_CAN_NOT_BE_EMPTY);
		}
		if (password == null && "".equals(password)) {
			throw new SystemException(SystemEnCode.PASSWORD_CAN_NOT_BE_EMPTY);
		}

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userId", userId);
		User loginUser = userExtendMapper.getUserInfoByUserId(paramMap);
		return loginUser;
	}

}
