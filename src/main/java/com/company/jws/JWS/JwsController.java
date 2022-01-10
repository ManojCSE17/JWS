package com.company.jws.JWS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.jws.JWS.entity.User;
import com.company.jws.JWS.repo.UserJpaRepository;

@Controller
public class JwsController {

	@Autowired
	private UserJpaRepository repos;

	@RequestMapping("/JWS/")
	public String indexPage() {
		return "index.jsp";
	}

	@PostMapping(value = "/signin")
	public String logUser(@RequestParam(name = "signinInputEmail") String email,
			@RequestParam(name = "signinInputPassword") String password) {

		User u = repos.findById(email);

		if (u != null) {
			if (u.getPassword().equals(password)) {
				return "LogInResponse.jsp";
			} else {
				return "errorLogIn.jsp";
			}
		} else {
			return "errorLogIn.jsp";
		}

	}
}
