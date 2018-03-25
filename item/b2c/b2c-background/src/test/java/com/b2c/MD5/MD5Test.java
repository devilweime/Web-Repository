package com.b2c.MD5;


import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class MD5Test {
	
	@Test
	public void md5test(){
		String md5Hex = DigestUtils.md5Hex("1");
		System.out.println(md5Hex);
	}
	@Test
	public void encrypt(){
		String  userName = "10000";
		String  password="123456";
		byte[] userByte = DigestUtils.md5(userName);
		StringBuffer salt = new StringBuffer();
		int mdLength = userByte.length%2 == 0 ? userByte.length/2:(userByte.length+1)/2;
		for (int i = mdLength-1; i < mdLength; i++) {
			salt.append(userByte[i]);
		}
		byte[] passwordByte = DigestUtils.md5(password);
		for (int i = passwordByte.length-1; i < passwordByte.length; i++) {
			salt.append(passwordByte[i]);
		}
		String md5Hex = DigestUtils.md5Hex(password+salt);
		System.out.println(md5Hex);
		
	}
}
