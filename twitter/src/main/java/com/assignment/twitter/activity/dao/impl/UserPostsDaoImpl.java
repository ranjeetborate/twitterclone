package com.assignment.twitter.activity.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.twitter.activity.dao.IUserPostsDao;
import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.activity.repo.UserPostsRepository;

@Component
public class UserPostsDaoImpl implements IUserPostsDao{

	@Autowired
	private UserPostsRepository userPostsRepository;

	@Override
	public List<UserPosts> findAllCreatedPostsByUserId(Long userId) {
		return userPostsRepository.findByuserid(userId);
	}

	@Override
	public UserPosts createUserPost(UserPosts userposts) {
		return userPostsRepository.save(userposts);
	}

	@Override
	public UserPosts checkIfPostExistsWithPostsIdAndUserId(Long postId, Long userId) {
		return userPostsRepository.checkIfPostExistsWithPostsIdAndUserId(postId, userId);
	}
}
