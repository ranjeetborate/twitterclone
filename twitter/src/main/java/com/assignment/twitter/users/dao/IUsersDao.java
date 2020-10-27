package com.assignment.twitter.users.dao;

import java.util.List;
import java.util.Optional;

import com.assignment.twitter.users.model.Users;

public interface IUsersDao {

	Users findByUsername(String username);

	Users createUser(Users user);

	List<Users> findAllUsersByUsername(String username);

	Optional<Users> findById(Long id);

}
