package com.softuni.models;

import javax.persistence.*;

import com.softuni.models.enums.RouteCategory;

@Entity
@Table(name = "categories")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RouteCategory name;

	@Column(columnDefinition = "TEXT")
	private String description;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public RouteCategory getName() {
		return name;
	}

	public void setName(RouteCategory name) {
		this.name = name;
	}

	public String getDesription() {
		return description;
	}

	public void setDesription(String desription) {
		this.description = desription;
	}

}
