package com.sites.navkar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.sites.navkar.entity.User;
import com.sites.navkar.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User validateAndGetUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user != null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public Optional<User> getUserDetail(Long id) {
		return userRepository.findById(id);
	}

	public String deleteUser(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return "User Deleted Successfully";
		} else {
			return "User Not Found";
		}
	}

	public Optional<User> updateUser(Long id, User updatedUser) {
		return userRepository.findById(id).map(existingUser -> {
			// Update only the fields provided in updatedUser
			if (updatedUser.getName() != null) {
				existingUser.setName(updatedUser.getName());
			}
			if (updatedUser.getEmail() != null) {
				existingUser.setEmail(updatedUser.getEmail());
			}
			if (updatedUser.getPassword() != null) {
				existingUser.setPassword(updatedUser.getPassword());
			}
			if (updatedUser.getPhoneNumber() != null) {
				existingUser.setPhoneNumber(updatedUser.getPhoneNumber());
			}

			// Optionally update the bookings, if provided
			if (updatedUser.getBookings() != null) {
				existingUser.getBookings().clear(); // Clear existing bookings
				existingUser.getBookings().addAll(updatedUser.getBookings());
			}

			// Save the updated user
			return userRepository.save(existingUser);
		});
	}

	public User saveUser(User user) {
		return userRepository.save(user);
	}
}
