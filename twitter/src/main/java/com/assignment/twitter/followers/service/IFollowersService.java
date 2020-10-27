package com.assignment.twitter.followers.service;

import java.util.List;

import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.utility.customexceptions.BusinessException;

public interface IFollowersService {

	Followers followUserByUserName(String username, Long loggedInUserId) throws BusinessException;

	List<Posts> fetchFollowedPeoplesPostsByUserId(Long userId);

}
