package com.assignment.twitter.followers.rest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.followers.service.IFollowersService;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@RestController
@RequestMapping("/followers")
public class FollowersRestImpl {

	@Autowired
	private IFollowersService followersService;
	
	@RequestMapping(value = "/followUserByUserName/{username}/{loggedInUserId}", method = RequestMethod.GET)
	public Followers followUserByUserName(@PathVariable("username") String username, @PathVariable("loggedInUserId") Long loggedInUserId) throws JSONException, BusinessException{
		return followersService.followUserByUserName(username, loggedInUserId);
	}

}
