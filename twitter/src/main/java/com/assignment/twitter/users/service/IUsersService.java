package com.assignment.twitter.users.service;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;

import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.utility.customexceptions.BusinessException;

public interface IUsersService {

	Users findByUsername(String username);

	Users createUser(Users users) throws JSONException, BusinessException;

	List<Users> findAllUsersByUsername(String username);

	Optional<Users> findById(Long id);

}
