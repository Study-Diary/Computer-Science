package com.study.staticfinal.common;

import java.util.Base64;

public class PasswordUtils {
	private static final Base64.Encoder encoder = Base64.getEncoder();

	private PasswordUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String encode(String plainPassword) {
		return encoder.encodeToString(plainPassword.getBytes());
	}

	public static boolean match(String plainPassword, String encodedPassword) {
		return encoder.encodeToString(plainPassword.getBytes()).equals(encodedPassword);
	}
}
