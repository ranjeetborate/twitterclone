package com.assignment.twitter.users.rest;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.users.service.IUsersService;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@RestController
@RequestMapping("/users")
public class UsersRestImpl {

	@Autowired
	private IUsersService usersService;
	
	@RequestMapping(value = "/findByUsername", method = RequestMethod.GET)
	public Users findByUsername(@RequestParam("username") String username) {
		return usersService.findByUsername(username);
	}
	
	@RequestMapping(value = "/findAllUsersByUsername", method = RequestMethod.GET)
	public List<Users> findAllUsersByUsername(@RequestParam("username") String username) {
		return usersService.findAllUsersByUsername(username);
	}

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public Users createUser(@RequestBody Users users) throws JSONException, BusinessException{
		return usersService.createUser(users);
	}

}
