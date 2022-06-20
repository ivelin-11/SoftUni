package com.softuni.mobilele.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softuni.mobilele.model.dto.UserLoginDTO;
import com.softuni.mobilele.model.dto.UserRegisterDTO;
import com.softuni.mobilele.model.entity.UserEntity;
import com.softuni.mobilele.repository.UserRepository;
import com.softuni.mobilele.user.CurrentUser;

@Service
public class UserService {

	private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	private UserRepository userRepository;

	private CurrentUser currentUser;

	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, CurrentUser currentUser, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.currentUser = currentUser;
		this.passwordEncoder = passwordEncoder;
	}

	public void registerAndLogin(UserRegisterDTO userRegisterDTO) {
		UserEntity user = new UserEntity();

		user.setActive(true);
		user.setEmail(userRegisterDTO.getEmail());
		user.setFirstName(userRegisterDTO.getFirstName());
		user.setLastName(userRegisterDTO.getLastName());
		user.setPassword(passwordEncoder.encode(userRegisterDTO.getPassword()));

		userRepository.save(user);

		login(user);
	}

	public boolean login(UserLoginDTO loginDTO) {
		Optional<UserEntity> userOptional = userRepository.findByEmail(loginDTO.getUsername());

		if (userOptional.isEmpty()) {
			// it uses var args {}
			LOGGER.info("User not found. Username [{}]", loginDTO.getUsername());
			return false;
		}

		String /* var */ rawPassword = loginDTO.getPassword();
		String /* var */ hashedPassword = userOptional.get().getPassword();

		boolean success = passwordEncoder.matches(rawPassword, hashedPassword);

		if (success) {
			login(userOptional.get());
		} else {
			logout();
		}

		return success;
	}

	private void login(UserEntity userEntity) {
		currentUser.setLoggedIn(true);
		currentUser.setName(userEntity.getFirstName() + " " + userEntity.getLastName());
	}

	public void logout() {
		currentUser.clear();
	}
}
