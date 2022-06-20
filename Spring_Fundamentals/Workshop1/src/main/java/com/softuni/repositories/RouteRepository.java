package com.softuni.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.softuni.models.Route;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

	@Query("SELECT r FROM Route AS r ORDER BY size(r.comments) DESC ")
	List<Route> findMostCommented();
}
