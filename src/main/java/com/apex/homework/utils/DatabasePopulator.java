package com.apex.homework.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.apex.homework.entity.User;
import com.apex.homework.repository.UserRepository;

@Component
public class DatabasePopulator {
	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	public void populateTables() {
		User abc = new User("Abc", encoder.encode("Abc_Password"), 100f, 200f, 300f);
		userRepository.save(abc);
		abc = new User("Guillermo", encoder.encode("Guillermo_Password"), 500f, 600f, 400f);
		userRepository.save(abc);
		abc = new User("Mike", encoder.encode("Mike_Password"), 1000f, 5000f, 10f, 50f);
		userRepository.save(abc);
		abc = new User("Greg", encoder.encode("Greg_Password"), 2000f, 60f, 30f, 10f, 1f);
		userRepository.save(abc);
	}
}
