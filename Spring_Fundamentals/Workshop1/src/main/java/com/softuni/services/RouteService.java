package com.softuni.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softuni.models.Route;
import com.softuni.repositories.RouteRepository;

@Service
public class RouteService {

	private RouteRepository routeRepository;

	@Autowired
	public RouteService(RouteRepository routeRepository) {
		this.routeRepository = routeRepository;
	}

	public List<Route> getMostCommented() {

		return routeRepository.findMostCommented();
	}

}
