package com.assignment.twitter.users.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.twitter.users.dao.IUsersDao;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.users.repo.UserRepository;

@Component
public class UsersDaoImpl implements IUsersDao{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public Users findByUsername(String username) {
		return userRepository.findUserByusername(username);
	}

	@Override
	public Users createUser(Users user) {
		return userRepository.save(user);
	}

	@Override
	public List<Users> findAllUsersByUsername(String username) {
		return userRepository.findUserByusernameContaining(username);
	}
	
	@Override
	public Optional<Users> findById(Long id) {
		System.out.println("findById "+id);
		return userRepository.findById(id);
	}
}
