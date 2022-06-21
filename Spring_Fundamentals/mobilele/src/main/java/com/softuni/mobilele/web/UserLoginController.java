package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.softuni.mobilele.model.dto.UserLoginDTO;
import com.softuni.mobilele.service.UserService;

@Controller
@RequestMapping("/users")
public class UserLoginController {

	UserService userService;

	public UserLoginController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/login")
	public String login() {

		return "auth-login";
	}

	@GetMapping("/logout")
	public String logout() {
		userService.logout();

		return "redirect:/";
	}

	// name of the class fields and
	// name in html must be the same
	@PostMapping("/login")
	public String login(UserLoginDTO userLoginDTO) {
		// dont forget to call the login method

		System.out.println("User is logged:" + userService.login(userLoginDTO));
		return "redirect:/";
	}

}
