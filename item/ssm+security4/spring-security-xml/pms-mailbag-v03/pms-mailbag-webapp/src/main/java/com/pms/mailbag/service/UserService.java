package com.pms.mailbag.service;

import com.pms.mailbag.dao.model.User;

public interface UserService {

	User checkUser(User user);

	String getUserInfo(User user);

	String updatePassword(String username,String oldPassword,String newPassword);

}
