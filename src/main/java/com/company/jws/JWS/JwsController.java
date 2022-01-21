package com.company.jws.JWS;

import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.company.jws.JWS.entity.User;
import com.company.jws.JWS.repo.UserJpaRepository;

@Controller
public class JwsController {

	private Document doc;

	@Autowired
	private UserJpaRepository repos;

	@PostMapping("/error-response")
	@ResponseBody
	public String sendResponse() {
		if (doc != null) {
			String h = doc.toString();
			doc = null;
			// checking commit
			return h;
		}
		return "<br><br><br><div style='width:100%;height:auto;text-align:center;color:#F93154;'><h1>404 Not Found<h1></div>";
	}

	@RequestMapping("/JWS/")
	public String indexPage() {
		return "index.jsp";
	}

	@PostMapping(value = "/signin")
	public ModelAndView logUser(@RequestParam(name = "signinInputEmail") String email,
			@RequestParam(name = "signinInputPassword") String password) {

		boolean emailValidation = Pattern.compile("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*(?:-[a-zA-Z0-9]+)*@company.com$")
				.matcher(email).matches();

		boolean passwordValidation = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$]).{8,20}$")
				.matcher(password).matches();

		ModelAndView mv = new ModelAndView();

		if (emailValidation && passwordValidation) {
			User u = repos.findById(email);

			if (u != null) {
				if (u.getPassword().equals(password)) {
					mv.addObject("user_name", u.getFullName());
					mv.setViewName("LogInResponse.jsp");
					return mv;
				} else {
					mv.setViewName("errorLogIn.jsp");
					return mv;
				}
			} else {
				mv.setViewName("errorLogIn.jsp");
				return mv;
			}
		} else {
			mv.setViewName("errorLogIn.jsp");
			return mv;
		}

	}

	@PostMapping(value = "/signup")
	public String registerUser(HttpServletRequest req, @RequestParam(name = "signupFullName") String name,
			@RequestParam(name = "signupGender") String gender, @RequestParam(name = "signupInputEmail") String email,
			@RequestParam(name = "signupInputPassword") String password,
			@RequestParam(name = "signupConfirmPassword") String confirmPassword) {

		boolean nameValidation = Pattern.compile("^[a-zA-Z]{3,10}(\\s[a-zA-Z]{3,10}){0,2}$").matcher(name).matches();

		boolean genderValidation = Pattern.compile("^Male|Female$").matcher(gender).matches();

		boolean emailValidation = Pattern.compile("^[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9]+)*(?:-[a-zA-Z0-9]+)*@company.com$")
				.matcher(email).matches();

		boolean passwordValidation = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$]).{8,20}$")
				.matcher(password).matches();

		boolean confirmPasswordValidation = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$]).{8,20}$")
				.matcher(confirmPassword).matches();

		if (nameValidation && genderValidation && emailValidation && passwordValidation && confirmPasswordValidation) {
			User u = repos.findById(email);
			if (u == null) {
				if (password.equals(confirmPassword)) {
					User nu = new User(email, name, gender, password);
					repos.insert(nu);
					return "LogInResponse.jsp";
				} else {
					try {
						doc = Jsoup.connect("http://localhost:8080/JWS/SignUp.jsp").get();
						Element err = doc.getElementById("errorSignUp");
						err.append("<h4 class='p-1' style='color:#FFF'>Please make sure your passwords match!</h4>");
						return "/error-response";
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}

			} else {
				try {
					doc = Jsoup.connect("http://localhost:8080/JWS/SignUp.jsp").get();
					Element err = doc.getElementById("errorSignUp");
					err.append("<h4 class='p-1' style='color:#FFF'>User already exists. Please signin!</h4>");
					return "/error-response";
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		} else {

			try {
				doc = Jsoup.connect("http://localhost:8080/JWS/SignUp.jsp").get();
				Element err = doc.getElementById("errorSignUp");
				err.append("<h4 class='p-1' style='color:#FFF'>Please provide correct details!<h4>");
				return "/error-response";
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

		return "errorLogIn.jsp";

	}
}
