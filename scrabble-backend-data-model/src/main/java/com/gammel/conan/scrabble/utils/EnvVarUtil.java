package com.gammel.conan.scrabble.utils;

public class EnvVarUtil {

	
	public static String getValue(String key) {
		String value = System.getenv(key);
		if(value == null) {
			return System.getProperty(key);
		}
		return value;
	}
}
