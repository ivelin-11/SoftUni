package com.softuni.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.softuni.models.Route;
import com.softuni.services.RouteService;

@Controller
public class HomeController {

	private RouteService routeService;

	@Autowired
	public HomeController(RouteService routeService) {
		this.routeService = routeService;
	}

	@GetMapping("/home")
	public String home(Model model) {
		List<Route> route = routeService.getMostCommented();

		model.addAttribute("mostCommented", route.get(0));
		return "index";
	}
}
