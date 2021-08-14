package com.apex.homework.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

	private String token;
	private String username;

	public LoginResponse(String accessToken, String username) {
		this.token = accessToken;
		this.username = username;
	}

}
