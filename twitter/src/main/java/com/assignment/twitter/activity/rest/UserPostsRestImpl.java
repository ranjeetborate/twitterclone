package com.assignment.twitter.activity.rest;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.activity.service.IUserPostsService;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@RestController
@RequestMapping("/userposts")
public class UserPostsRestImpl {

	@Autowired
	private IUserPostsService userPostsService;
	
	@RequestMapping(value = "/findAllCreatedPostsByUserId/{userId}", method = RequestMethod.GET)
	public List<UserPosts> findAllCreatedPostsByUserId(@PathVariable("userId") Long userId) throws JSONException, BusinessException{
		return userPostsService.findAllCreatedPostsByUserId(userId);
	}
	
	@RequestMapping(value = "/createUserPost", method = RequestMethod.POST)
	public UserPosts createUserPost(@RequestBody UserPosts userposts) throws JSONException, BusinessException{
		return userPostsService.createUserPost(userposts);
	}

	@RequestMapping(value = "/fetchAllActivityOfUser/{userId}", method = RequestMethod.GET)
	public List<Posts> fetchAllActivityOfUser(@PathVariable("userId") Long userId) throws JSONException, BusinessException{
		return userPostsService.fetchAllActivityOfUser(userId);
	}
}
