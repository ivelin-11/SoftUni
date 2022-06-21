package com.softuni.mobilele.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.softuni.mobilele.model.dto.UserRegisterDTO;
import com.softuni.mobilele.service.UserService;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

	private final UserService userService;

	public UserRegistrationController(UserService userService) {
		this.userService = userService;
	}

	// can be directly access in the view/html document
	@ModelAttribute("userModel")
	public void initUserModel(Model model) {
		model.addAttribute("userModel", new UserRegisterDTO());
	}

	@GetMapping("/register")
	public String register() {

		return "auth-register";
	}

	@PostMapping("/register")
	// binding result must be after validated object because it is obliged
	// if there is no binding result it throw exception
	// validiation is executed before calling of the method
	public String register(@Valid UserRegisterDTO userModel, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {

		if (bindingResult.hasErrors()) {
			// to not loose data when redirecting
			// flash atribbute - atribute which is kept after redirect in user session
			// override the userModel from ModelAttribute -same as global init for all
			// mappings
			redirectAttributes.addFlashAttribute("userModel", userModel);
			redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",
					bindingResult);
			// POST -> html when press refresh it will be resumbited
			// post - redirect -get it will execute ge mapping by pressing refresh
			return "redirect:/users/register";
		}

		userService.registerAndLogin(userModel);
		return "redirect:/";
	}
}
