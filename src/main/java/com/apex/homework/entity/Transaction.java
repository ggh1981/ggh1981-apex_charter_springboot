package com.apex.homework.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
public class Transaction extends EntityBase {
	@Getter
	@Setter
	private Float amount;
}
