package com.assignment.twitter.posts.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.twitter.posts.dao.IPostsDao;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.posts.repo.PostsRepository;

@Component
public class PostsDaoImpl implements IPostsDao{

	@Autowired
	private PostsRepository postsRepository;

	@Override
	public Posts createPost(Posts posts) {
		return postsRepository.save(posts);
	}

	@Override
	public Optional<Posts> findPostById(Long id) {
		return postsRepository.findById(id);
	}
}
