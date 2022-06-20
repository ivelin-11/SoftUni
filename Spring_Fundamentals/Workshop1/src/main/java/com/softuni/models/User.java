package com.softuni.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.softuni.models.enums.UserLevel;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false, unique = true)
	private String username;

	@Column(nullable = false, name = "full_name")
	private String fullName;

	@NotNull
	private int age;

	@Column(nullable = false)
	private String password;

	@Column(unique = true)
	private String email;

	@ManyToMany(fetch = FetchType.EAGER)
	private Set<Role> roles = new HashSet<>();

	@Enumerated(EnumType.STRING)
	private UserLevel level;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public UserLevel getLevel() {
		return level;
	}

	public void setLevel(UserLevel level) {
		this.level = level;
	}
}
