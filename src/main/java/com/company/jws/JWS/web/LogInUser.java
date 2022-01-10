package com.company.jws.JWS.web;

import com.company.jws.JWS.entity.User;
import com.company.jws.JWS.repo.UserJpaRepository;

import lombok.Data;

@Data
public class LogInUser {

	private UserJpaRepository repos;

	public User checkUser(String email, String password) {
		repos = new UserJpaRepository();
		User u = repos.findById(email);
		if (u != null) {
			if (u.getPassword().equals(password)) {
				return u;
			}
		}
		return null;
	}

}
