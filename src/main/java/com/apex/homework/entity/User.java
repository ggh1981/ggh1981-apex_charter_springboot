package com.apex.homework.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User extends EntityBase {

	private String password;
	@Column(unique = true)
	private String username;
	@JsonBackReference
	@OneToOne(targetEntity = Customer.class, cascade = CascadeType.ALL)
	private Customer customer;

	public User() {
	}

	public User(String username, String password, Float... amounts) {
		this.username = username;
		this.password = password;
		customer = new Customer();

		if (amounts != null && amounts.length > 0) {
			List<Transaction> tranList = new ArrayList<>();
			for (Float amount : amounts) {
				Transaction transaction = new Transaction();
				transaction.setAmount(amount);
				tranList.add(transaction);
			}
			customer.setTransactions(tranList);
		}
	}
}