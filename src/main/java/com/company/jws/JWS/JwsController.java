package com.company.jws.JWS;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JwsController {

	@RequestMapping("/JWS/")
	public String indexPage() {
		return "index.jsp";
	}
}
