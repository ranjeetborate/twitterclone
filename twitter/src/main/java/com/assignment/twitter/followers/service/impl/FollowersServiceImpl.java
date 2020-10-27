package com.assignment.twitter.followers.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.twitter.activity.dao.IUserPostsDao;
import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.followers.dao.IFollowersDao;
import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.followers.service.IFollowersService;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.users.service.IUsersService;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@Service
public class FollowersServiceImpl implements IFollowersService{

	@Autowired
	private IFollowersDao followersDao;
	
	@Autowired
	private IUsersService usersService;

	@Autowired
	private IUserPostsDao userPostsDao;

	@Override
	public Followers followUserByUserName(String username, Long loggedInUserId) throws BusinessException {
		Users user = usersService.findByUsername(username);
		if(user!=null) {
			try {
				Optional<Users> loggedInUser = usersService.findById(loggedInUserId);
				Users userObject = loggedInUser.get(); 
				Followers followerDetails = new Followers();
				followerDetails.setId(null);
				followerDetails.setFollowingto(user);
				followerDetails.setUserid(userObject);
				return followersDao.followUserByUserName(followerDetails);		
			}catch(Exception e) {
				throw new BusinessException("No such user found or users is not registered");				
			}
		}else {
			throw new BusinessException("No user found with the specified username");
		}
	}

	@Override
	public List<Posts> fetchFollowedPeoplesPostsByUserId(Long userId) {
		System.out.println("userId "+userId);
		List<Posts> postsList = new ArrayList();
		List<Followers> followersList = followersDao.fetchFollowedPeoplesPostsByUserId(userId);
		for(Followers user : followersList) {
			System.out.println("userrrrr "+user.getFollowingto().getId());
			List<UserPosts> userPostsList = userPostsDao.findAllCreatedPostsByUserId(user.getFollowingto().getId());
			for(UserPosts userPosts : userPostsList) {
				postsList.add(userPosts.getPostid());
			}					
		}
		return postsList;
	}
	
}
