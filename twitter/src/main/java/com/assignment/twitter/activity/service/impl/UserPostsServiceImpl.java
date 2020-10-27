package com.assignment.twitter.activity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.twitter.activity.dao.IUserPostsDao;
import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.activity.service.IPostsActivityService;
import com.assignment.twitter.activity.service.IUserPostsService;
import com.assignment.twitter.followers.service.IFollowersService;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.users.dao.IUsersDao;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@Service
public class UserPostsServiceImpl implements IUserPostsService{

	@Autowired
	private IUserPostsDao userPostsDao;

	@Autowired
	private IPostsActivityService postsActivityService;

	@Autowired
	private IFollowersService followersService;

	@Autowired
	private IUsersDao usersDao;

	@Override
	public List<UserPosts> findAllCreatedPostsByUserId(Long userId) throws BusinessException {
		try {
			Optional<Users> fetchedOptionalUser = usersDao.findById(userId);
			Users fetchedUser = fetchedOptionalUser.get();
		}catch(Exception e) {
			throw new BusinessException("No such user found with the specified Id");			
		}
		return userPostsDao.findAllCreatedPostsByUserId(userId);
	}

	@Override
	public UserPosts createUserPost(UserPosts userposts) throws BusinessException {
		Users user = userposts.getUserid();
		if(user==null || (user !=null && user.getId() == null && user.getUsername() == null)) {			
			throw new BusinessException("Please provide a valid User");
		}
		try {
			Optional<Users> fetchedOptionalUser = usersDao.findById(user.getId());
			Users fetchedUser = fetchedOptionalUser.get();
		}catch(Exception e) {
			throw new BusinessException("No such user found with the specified Id");			
		}
		Posts post = userposts.getPostid();
		if((post == null) || (post.getId() == 0 && post.getPostcontent() == null)) {
			throw new BusinessException("No valid content provided in the Post");			
		}

		if(post != null && post.getId() == 0 && post.getPostcontent() != null && post.getPostcontent().length()>140) {
			throw new BusinessException("Post's length must not be greater than 140 characters");			
		}
		
		return userPostsDao.createUserPost(userposts);
	}

	@Override
	public List<Posts> fetchAllActivityOfUser(Long userId) throws BusinessException {
		List<Posts> finalPosts = new ArrayList();
		
		try {
			Optional<Users> fetchedOptionalUser = usersDao.findById(userId);
			Users fetchedUser = fetchedOptionalUser.get();
		}catch(Exception e) {
			throw new BusinessException("No such user found with the specified Id");			
		}
		
		List<Posts> fetchedLikedPosts = postsActivityService.findAllLikedPostsByUserId(userId);
		if(fetchedLikedPosts!=null && fetchedLikedPosts.size()>0) {
			finalPosts.addAll(fetchedLikedPosts);
		}
		
		List<Posts> fetchedFollowedPeoplesPosts = followersService.fetchFollowedPeoplesPostsByUserId(userId);
		System.out.println("fetchedFollowedPeoplesPosts "+fetchedFollowedPeoplesPosts.size());
		if(fetchedLikedPosts!=null && fetchedLikedPosts.size()>0) {
			fetchedLikedPosts.addAll(fetchedFollowedPeoplesPosts);
		}

		return finalPosts;
	}
	
	
}
