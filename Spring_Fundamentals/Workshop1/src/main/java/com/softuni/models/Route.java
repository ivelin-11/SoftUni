package com.softuni.models;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import com.softuni.models.enums.Level;

@Entity
@Table(name = "routes", uniqueConstraints = { @UniqueConstraint(columnNames = { "author_id", "name" }) })
public class Route {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Lob // doesn't connect us with the current type of the current version
	@Column(/* columnDefinition = "MEDIUMTEXT", */ name = "gpx_coordinates")
	private String gpxCoordinates;

	@Enumerated(EnumType.STRING)
	private Level level;

	private String name;

	@Column(columnDefinition = "TEXT")
	private String description;

	@ManyToOne
	private User author;

	@Column(name = "video_url")
	private String videoUrl;

	// from this class to the comments is looked the direction of the cascade
	@OneToMany(mappedBy = "route", targetEntity = Comment.class, cascade = CascadeType.ALL)
	private Set<Comment> comments;

	@OneToMany(mappedBy = "route", targetEntity = Picture.class, fetch = FetchType.EAGER)
	private Set<Picture> pictures;

	@ManyToMany
	private Set<Category> categories = new HashSet<>();

	public Route() {
		pictures = new HashSet<>();
		comments = new HashSet<>();
		categories = new HashSet<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getGpxCoordinates() {
		return gpxCoordinates;
	}

	public void setGpxCoordinates(String gpxCoordinates) {
		this.gpxCoordinates = gpxCoordinates;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Picture> getPictures() {
		return Collections.unmodifiableSet(pictures);
	}

	public void setPictures(Set<Picture> pictures) {
		this.pictures = pictures;
	}

	public Set<Category> getCategories() {
		return Collections.unmodifiableSet(categories);
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}

}
