package com.apex.homework.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction extends EntityBase {
	private Float amount;
}
