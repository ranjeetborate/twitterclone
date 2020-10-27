package com.assignment.twitter.followers.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.twitter.followers.dao.IFollowersDao;
import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.followers.repo.FollowersRepository;
import com.assignment.twitter.users.model.Users;

@Component
public class FollowersDaoImpl implements IFollowersDao{

	@Autowired
	FollowersRepository followersRepository;

	@Override
	public Followers followUserByUserName(Followers follower) {
		return followersRepository.save(follower);
	}

	@Override
	public List<Followers> fetchFollowedPeoplesPostsByUserId(Long userId) {
		return followersRepository.fetchFollowedPeoplesPostsByUserId(userId);
	}
	
	
}
