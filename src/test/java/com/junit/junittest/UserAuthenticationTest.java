package com.junit.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.junittest.modal.User;

public class UserAuthenticationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Altaf").password("borsok").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Aibek").password("borsok").role("User").build());
		Authentication.userList.add(User.builder().userName("Nick").password("borsok").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Neil").password("borsok").role("Tester").build());
	}

	@Test
	public void testLogin() {
		Authentication authentication = new Authentication();
		assertEquals(true, authentication.login("Aibek", "borsok"));
	}
	
	@Test
	public void testWrongUserLogin() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Nick", "borsok"));
	}

	@Test
	public void testUserAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "borsok"));
		
		assertEquals("Altaf", authentication.getUserName());
	}
	
	@Test
	public void testRoleAssert() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "borsok"));
		
		assertEquals("Admin", authentication.getRole());
	}

	@Test
	public void testLogout() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "borsok"));
		
		authentication.logout();
		
		assertEquals(null, authentication.getRole());
	}
	
}
