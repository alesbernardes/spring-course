package com.springcourse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcourse.domain.User;
import com.springcourse.repository.UserRepository;

@Service
public class UserService {
	
	//save
	@Autowired private UserRepository userRepository;
	public User save(User user) {
		User createUser = userRepository.save(user);
		return createUser;
	}
	//update
	public User update(User user) {
		User updateUser = userRepository.save(user);
		return updateUser;
	}
	//get
	public User getById(Long id) {
		Optional<User> result = userRepository.findById(id);
		return result.get();
	}
	//list
	public List<User> listAll() {
		List<User>users = userRepository.findAll();
		return users;
	}
	//login
	public User login(String email, String password) {
		Optional<User> result = userRepository.login(email, password);
		return result.get();
	}
	
}
