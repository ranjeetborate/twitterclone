package com.assignment.twitter.posts.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.twitter.posts.dao.IPostsDao;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.posts.service.IPostsService;

@Service
public class PostsServiceImpl implements IPostsService{

	@Autowired
	IPostsDao postsDao;
	
	@Override
	public Posts createPost(Posts posts) {
		return postsDao.createPost(posts);
	}

}
