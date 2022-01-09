package com.company.jws.JWS.web;

import org.springframework.beans.factory.annotation.Autowired;

import com.company.jws.JWS.entity.User;
import com.company.jws.JWS.repo.UserJpaRepository;

import lombok.Data;

@Data
public class LogInUser {

	@Autowired
	private UserJpaRepository repo;

	public User checkUser(String email, String password) {
		User u = repo.findById(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

}
