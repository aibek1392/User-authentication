package com.junit.junittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.junittest.modal.User;

public class UserAuthorizationTest {
	
	@BeforeEach
	public void setup() {
		Authentication.userList.add(User.builder().userName("Altaf").password("borsok").role("Admin").build());
		Authentication.userList.add(User.builder().userName("Aibek").password("borsok").role("User").build());
		Authentication.userList.add(User.builder().userName("Nick").password("borsok").role("Developer").build());
		Authentication.userList.add(User.builder().userName("Neil").password("borsok").role("Tester").build());
	}

	@Test
	public void testWelcomePageAccess(){

		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Aibek", "borsok"));

		Authorization authorization = new Authorization(authentication);
		
		assertEquals(true, authorization.hasAccess("welcome"));
	}
	
	@Test
	public void testAdminPageAccess() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "borsok"));

		Authorization authorization = new Authorization(authentication);
		
		assertEquals(true, authorization.hasAccess("admin"));

	}
	
	@Test
	public void testWelcomePageAccessWithoutLogin(){
	Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Altaf", "borsok"));
		
		authentication.logout();

		Authorization authorization = new Authorization(authentication);
		
		assertEquals(false, authorization.hasAccess("admin"));
		
	}
	
	@Test
	public void testAdminPageNotAccessable() {
		Authentication authentication = new Authentication();
		
		assertEquals(true, authentication.login("Neil", "borsok"));

		Authorization authorization = new Authorization(authentication);
		
		assertEquals(false, authorization.hasAccess("admin"));

	}
	
}
