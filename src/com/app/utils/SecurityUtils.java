package com.app.utils;

import java.security.MessageDigest;

public class SecurityUtils {
	
	public static MessageDigest getMD() {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (Exception e) {
			System.out.println(e);
		}
		return md;
	}
	
	public static byte[] getHash(String input) {
		return getMD().digest(input.getBytes());
	}
	
}
