package com.pms.mailbag.utils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.Key;
import java.util.Base64;

import javax.crypto.Cipher;

public class Des3 {
	private static final String algorithm = "DESede";//表示3DES算法

//	private static final String encryptKey = "6u^>H4Tmx;jbFEk}F.KXfY66>}tRk-va";

	private static String keyBase64="rO0ABXNyABRqYXZhLnNlY3VyaXR5LktleVJlcL35T7OImqVDAgAETAAJYWxnb3JpdGhtdAASTGphdmEvbGFuZy9TdHJpbmc7WwAHZW5jb2RlZHQAAltCTAAGZm9ybWF0cQB+AAFMAAR0eXBldAAbTGphdmEvc2VjdXJpdHkvS2V5UmVwJFR5cGU7eHB0AAZERVNlZGV1cgACW0Ks8xf4BghU4AIAAHhwAAAAGH8B2fEIPdO8StUs79U3uggLNFhdhs5uf3QAA1JBV35yABlqYXZhLnNlY3VyaXR5LktleVJlcCRUeXBlAAAAAAAAAAASAAB4cgAOamF2YS5sYW5nLkVudW0AAAAAAAAAABIAAHhwdAAGU0VDUkVU";
	
	private static Key key = null;
	
	static{
		byte[] b = Base64.getDecoder().decode(keyBase64.getBytes());
		try {
			ObjectInputStream ois=new ObjectInputStream(new ByteArrayInputStream(b));
			key=(Key) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static String encrypt(String source) {
		try {
			Cipher c1 = Cipher.getInstance(algorithm);
			c1.init(Cipher.ENCRYPT_MODE, key);
			byte[] bytes = c1.doFinal(source.getBytes());
			return Base64.getEncoder().encodeToString(bytes);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;

	}

	public static String decrypt(String entryptSource) {
		try {
			Cipher c1 = Cipher.getInstance(algorithm);
			c1.init(Cipher.DECRYPT_MODE, key);
			byte[] bytes=Base64.getDecoder().decode(entryptSource);
			bytes = c1.doFinal(bytes);
			return new String(bytes);
		} catch (java.security.NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		} catch (javax.crypto.NoSuchPaddingException e2) {
			e2.printStackTrace();
		} catch (java.lang.Exception e3) {
			e3.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		String pwd=Des3.encrypt("111111");
		System.out.println(pwd);
		String des3Password=Des3.decrypt("Nooxoitq1Po=");
		System.out.println(des3Password);
	}
}
