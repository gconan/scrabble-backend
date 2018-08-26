package com.gammel.conan.scrabble;

import static org.junit.Assert.fail;

import java.lang.reflect.Method;

import org.junit.Test;

public class ScrabbleAppTest {
	
	@Test
	public void testEnvVarsSet() throws NoSuchMethodException, SecurityException {
		System.setProperty("FILE_SYSTEM_PATH", "/hello/world");
		Method checkEnvVars = ScrabbleApp.class.getDeclaredMethod("checkEnvVars", (Class<?>[]) null);
		checkEnvVars.setAccessible(true);
		
		try {
			checkEnvVars.invoke((Object[])null, (Object[])null);
		}catch(Exception e) {
			fail("All Env Vars should be set");
		}finally {
			System.clearProperty("FILE_SYSTEM_PATH"); //clean up
		}
	}	
	
	@Test
	public void testEnvVarsNotSet() throws NoSuchMethodException, SecurityException {
		// intentionally commented out, checking that we throw exception if vars are not set
		//System.setProperty("FILE_SYSTEM_PATH", "/hello/world");
		
		Method checkEnvVars = ScrabbleApp.class.getDeclaredMethod("checkEnvVars", (Class<?>[]) null);
		checkEnvVars.setAccessible(true);
		
		try {
			checkEnvVars.invoke((Object[])null, (Object[])null);
			fail("No Env Vars are set, should have thrown exception");
		}catch(Exception e) {
		}finally {
			System.clearProperty("FILE_SYSTEM_PATH"); //cant hurt 
		}
	}
}
