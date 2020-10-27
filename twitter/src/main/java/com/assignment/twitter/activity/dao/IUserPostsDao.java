package com.assignment.twitter.activity.dao;

import java.util.List;

import com.assignment.twitter.activity.model.UserPosts;

public interface IUserPostsDao {

	List<UserPosts> findAllCreatedPostsByUserId(Long userId);

	UserPosts createUserPost(UserPosts userposts);

	UserPosts checkIfPostExistsWithPostsIdAndUserId(Long postId, Long userId);

}
