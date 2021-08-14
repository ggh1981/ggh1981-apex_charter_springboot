package com.apex.homework.utils;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apex.homework.entity.Transaction;

@Component
public class RewardsUtils {
	public int calculateRewards(List<Transaction> transactions) {
		int rewards = 0;
		LocalDate currentDate = LocalDate.now();
		LocalDate currentDateMinus3Months = currentDate.minusMonths(3);
		double sumAmounts = transactions.stream()
				.filter(element -> element.getCreationDate().isAfter(currentDateMinus3Months))
				.mapToDouble(i -> i.getAmount()).sum();
		int sumAmountsInt = (int) sumAmounts;
		if (sumAmounts > 100) {
			rewards = (sumAmountsInt - 100) * 2;
			if (sumAmountsInt > 50) {
				rewards = rewards + (sumAmountsInt - 50);
			}
		}
		return rewards;
	}
}
