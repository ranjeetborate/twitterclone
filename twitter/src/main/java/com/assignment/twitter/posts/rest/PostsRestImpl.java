package com.assignment.twitter.posts.rest;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.posts.service.IPostsService;
import com.assignment.twitter.users.model.Users;

@RestController
@RequestMapping("/posts")
public class PostsRestImpl {

	@Autowired
	IPostsService postsService;
	
	@RequestMapping(value = "/createPost", method = RequestMethod.POST)
	public Posts createPost(@RequestBody Posts posts) throws JSONException{
		return postsService.createPost(posts);
	}

}
