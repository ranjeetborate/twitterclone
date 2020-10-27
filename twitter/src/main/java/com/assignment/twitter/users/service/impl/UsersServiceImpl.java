package com.assignment.twitter.users.service.impl;

import java.util.List;
import java.util.Optional;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.twitter.users.dao.IUsersDao;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.users.service.IUsersService;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@Service
public class UsersServiceImpl implements IUsersService{

	@Autowired
	private IUsersDao usersDao;
	
	@Override
	public Users findByUsername(String username) {
		return usersDao.findByUsername(username);
	}

	@Override
	public Users createUser(Users users) throws JSONException, BusinessException {
		if(users == null)
			throw new BusinessException("Please provide a valid user");
		if(users!=null && users.getUsername()!=null) {
			Users existingUser = usersDao.findByUsername(users.getUsername());
			if(existingUser!=null)
				throw new BusinessException("User with username "+users.getUsername()+" already exists, please provide another username");			
		}
		return usersDao.createUser(users);			
	}

	@Override
	public List<Users> findAllUsersByUsername(String username) {
		return usersDao.findAllUsersByUsername(username);
	}

	@Override
	public Optional<Users> findById(Long id) {
		return usersDao.findById(id);
	}
}
