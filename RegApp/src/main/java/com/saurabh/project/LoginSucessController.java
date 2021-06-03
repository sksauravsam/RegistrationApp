package com.saurabh.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginSucessController {
	
	@RequestMapping("/loginsuccess")
	public String register() {
		return "/loginsuccess";
	}
}
