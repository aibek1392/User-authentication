package com.junit.junittest.modal;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Builder
public class User {
	
	private String userName;
	private String password;
	private String role;

}
