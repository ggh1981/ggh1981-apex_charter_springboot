package com.apex.homework.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apex.homework.auth.AuthUtils;
import com.apex.homework.entity.Transaction;
import com.apex.homework.entity.User;
import com.apex.homework.payload.RewardsResponse;
import com.apex.homework.repository.UserRepository;
import com.apex.homework.services.UserDetailsImpl;
import com.apex.homework.utils.RewardsUtils;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/customer")
public class RewardsController {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	AuthUtils authUtils;

	@Autowired
	RewardsUtils rewardsUtils;

	@Autowired
	UserRepository userRepository;

	@GetMapping("/rewards")
	public ResponseEntity<?> getRewards() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
		User user = userRepository.findByUsername(userDetails.getUsername()).get();
		List<Transaction> transactions = user.getCustomer().getTransactions();

		return ResponseEntity
				.ok(new RewardsResponse(user.getUsername(), transactions, rewardsUtils.calculateRewards(transactions)));
	}
}
