package com.assignment.twitter.activity.service;

import java.util.List;

import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.utility.customexceptions.BusinessException;

public interface IUserPostsService {

	List<UserPosts> findAllCreatedPostsByUserId(Long userId) throws BusinessException;

	UserPosts createUserPost(UserPosts userposts) throws BusinessException;

	List<Posts> fetchAllActivityOfUser(Long userId) throws BusinessException;

}
