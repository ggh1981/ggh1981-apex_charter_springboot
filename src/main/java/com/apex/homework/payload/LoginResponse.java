package com.apex.homework.payload;

import java.util.List;

import com.apex.homework.entity.Transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {

	private String id;
	private Integer rewards;
	private String token;
	private List<Transaction> transactions;
	private String username;

	public LoginResponse(String accessToken, String id, String username, List<Transaction> transactions,
			Integer rewards) {
		this.token = accessToken;
		this.id = id;
		this.username = username;
		this.transactions = transactions;
		this.rewards = rewards;
	}

}
