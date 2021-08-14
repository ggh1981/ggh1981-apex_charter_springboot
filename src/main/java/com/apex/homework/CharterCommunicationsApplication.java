package com.apex.homework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.apex.homework.utils.DatabasePopulator;

@SpringBootApplication
@EnableJpaAuditing
public class CharterCommunicationsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(CharterCommunicationsApplication.class, args);
		DatabasePopulator bean = ctx.getBean(DatabasePopulator.class);
		bean.populateTables();
	}
}