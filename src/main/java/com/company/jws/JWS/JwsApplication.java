package com.company.jws.JWS;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.jws.JWS.repo.UserJpaRepository;

@SpringBootApplication
public class JwsApplication implements CommandLineRunner {

	@Autowired
	private UserJpaRepository repo;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JwsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// logger.info("Inserting User -> {}", repo.insert(new
		// User("tara.james@company.com", "Tara James", "Female", "tara")));

		// logger.info("Inserting User -> {}", repo.insert(new
		// User("sruthi.hasan@company.com", "Sruthi Hasan", "Female", "h@san87")));

		// logger.info("Inserting User -> {}", repo.insert(new
		// User("john.carpenter@company.com", "John Carpenter", "Male", "john@Cap4")));

		// logger.info("User john.carpenter@company.com -> {}",
		// repo.findById("john.carpenter@company.com"));

		// logger.info("Updating tara.james@company.com -> {}", repo.update(new
		// User("tara.james@company.com", "Tara James", "Female", "tAr@32c")));

		// logger.info("Deleting User sruthi.hasan@company.com -> {}",
		// repo.deleteById("sruthi.hasan@company.com"));

		logger.info("Printing All users data {}", repo.findAll());

	}

}
