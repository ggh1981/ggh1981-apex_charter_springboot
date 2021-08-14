package com.apex.homework.payload;

import java.util.List;

import com.apex.homework.entity.Transaction;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RewardsResponse {

	private Integer rewards;
	private List<Transaction> transactions;
	private String username;

	public RewardsResponse(String username, List<Transaction> transactions, Integer rewards) {
		this.username = username;
		this.transactions = transactions;
		this.rewards = rewards;
	}

}
