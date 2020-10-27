package com.assignment.twitter.posts.dao;

import java.util.Optional;

import com.assignment.twitter.posts.model.Posts;

public interface IPostsDao {

	Posts createPost(Posts posts);

	Optional<Posts> findPostById(Long id);

}
