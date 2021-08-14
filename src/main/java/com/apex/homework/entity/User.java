package com.apex.homework.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
public class User extends EntityBase {
	@Getter
	@Setter
	private String password;
	@Getter
	@Setter
	@JsonBackReference
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	@Getter
	@Setter
	@Column(unique = true)
	private String username;
	
	public User() {
	}
	
	public User(String username, String password, Float... amounts) {
		this.username = username;
		this.password = password;
		if(amounts != null && amounts.length>0) {
			List<Transaction> tranList = new ArrayList<>();
			for(Float amount: amounts) {
				Transaction transaction = new Transaction();
				transaction.setAmount(amount);
				tranList.add(transaction);
			}
			this.transactions = tranList;
		}
	}
}