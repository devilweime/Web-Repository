package com.b2c.commons.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Utils {
	
	public static String encrypt(String userName,String password){
		byte[] userByte = DigestUtils.md5(userName);
		StringBuffer salt = new StringBuffer();
		int mdLength = userByte.length%2 == 0 ? userByte.length/2:(userByte.length+1)/2;
		for (int i = mdLength-1; i < mdLength; i++) {
			salt.append(userByte[i]);
			salt.append("c2b");
		}
		byte[] passwordByte = DigestUtils.md5(password);
		for (int i = passwordByte.length-1; i < passwordByte.length; i++) {
			salt.append(passwordByte[i]);
		}
		return DigestUtils.md5Hex(password+salt);
	}
}
