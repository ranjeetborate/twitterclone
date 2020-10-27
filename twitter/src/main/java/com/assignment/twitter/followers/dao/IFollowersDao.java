package com.assignment.twitter.followers.dao;

import java.util.List;

import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.users.model.Users;

public interface IFollowersDao {

	Followers followUserByUserName(Followers followerDetails);

	List<Followers> fetchFollowedPeoplesPostsByUserId(Long userId);

}
