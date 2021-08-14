package com.apex.homework.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.apex.homework.entity.Transaction;

@SpringBootTest
public class RewardsUtilsTest {

	@Autowired
	private RewardsUtils rewardsUtils;

	@Test
	public void calculateRewardsForOldTransactionsTest() {
		List<Transaction> oldTransactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.parse("2021-01-01"));
		oldTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.parse("2021-02-01"));
		oldTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.parse("2021-03-01"));
		oldTransactions.add(transaction);

		assertEquals(0, rewardsUtils.calculateRewards(oldTransactions));
	}

	@Test
	public void calculateRewardsForNewTransactionsWithAmountOf300Test() {
		List<Transaction> newTransactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);

		assertEquals(650, rewardsUtils.calculateRewards(newTransactions));
	}

	@Test
	public void calculateRewardsForNewTransactionsWithAmountOf1000Test() {
		List<Transaction> newTransactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(500f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(400f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(100f);
		transaction.setCreationDate(LocalDate.now());
		newTransactions.add(transaction);

		assertEquals(2750, rewardsUtils.calculateRewards(newTransactions));
	}

	@Test
	public void calculateRewardsForNegativeTransactionsTest() {
		List<Transaction> negativeTransactions = new ArrayList<Transaction>();
		Transaction transaction = new Transaction();
		transaction.setAmount(-100f);
		transaction.setCreationDate(LocalDate.now());
		negativeTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(-100f);
		transaction.setCreationDate(LocalDate.now());
		negativeTransactions.add(transaction);
		transaction = new Transaction();
		transaction.setAmount(-100f);
		transaction.setCreationDate(LocalDate.now());
		negativeTransactions.add(transaction);

		assertEquals(0, rewardsUtils.calculateRewards(negativeTransactions));
	}
}
