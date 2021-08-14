package com.apex.homework.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Customer extends EntityBase {
	@JsonBackReference
	@OneToMany(targetEntity = Transaction.class, cascade = CascadeType.ALL)
	private List<Transaction> transactions;
	@JsonBackReference
	@OneToOne(targetEntity = User.class, cascade = CascadeType.ALL)
	private User user;
}