package com.springcourse.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springcourse.domain.User;
import com.springcourse.enuns.Role;

@RunWith(SpringRunner.class)
@FixMethodOrder(Metha)
@SpringBootTest
public class UserRepositoryTestes {

	@Autowired
	private UserRepository userRepository;

	public void saveTest() {
		User user = new User(null,"kevin","ale@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User createdUser = userRepository.save(user);
		assertThat(createdUser.getId()).isEqualTo(1L);
	}

	public void updateTest() {
		User user = new User(1L,"kevin","ale@gmail.com", "123", Role.ADMINISTRATOR, null, null);
		User updateUser = userRepository.save(user);
		assertThat(updateUser.getName()).isEqualTo("Kevinho");
	}

	public void getByIdTest() {
		Optional<User> result = userRepository.findById(1L);
		User user = result.get();
		assertThat(user.getPassword()).isEqualTo("123");
	}

	public void listTest() {
		List(User> users = userRepository.findAll());
		
		assertThat(users.size()).isEqualTo(1);
	}

	public void loginTest() {
		Optional<User> result =userRepository.login("ale@gmail", "123");
		
	}
}
