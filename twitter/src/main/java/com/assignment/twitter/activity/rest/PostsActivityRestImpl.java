package com.assignment.twitter.activity.rest;

import java.util.List;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.twitter.activity.model.PostsActivity;
import com.assignment.twitter.activity.service.IPostsActivityService;
import com.assignment.twitter.utility.Views.LikedPostsView;
import com.assignment.twitter.utility.customexceptions.BusinessException;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/postsactivity")
public class PostsActivityRestImpl {

	@Autowired
	private IPostsActivityService postActivityService;
	
	@RequestMapping(value = "/likePost/{whoId}/{whoseId}/{postId}/{status}", method = RequestMethod.GET)
	public PostsActivity likePost(@PathVariable("whoId") Long whoId, @PathVariable("whoseId") Long whoseId, @PathVariable("postId") Long postId, @PathVariable("status") Integer status) throws JSONException, BusinessException{
		return postActivityService.likePost(status, whoId, whoseId, postId);
	}
	
	@RequestMapping(value = "/dislikePost", method = RequestMethod.POST)
	public PostsActivity dislikePost(@RequestBody PostsActivity postsActivityJson) throws JSONException{
		return postActivityService.dislikePost(postsActivityJson);
	}

	@RequestMapping(value = "/findPostByLikerId/{userId}", method = RequestMethod.GET)
	@JsonView(LikedPostsView.class)
	public List<PostsActivity> findPostByLikerId(@PathVariable("userId") Long userId) throws JSONException, BusinessException{
		return postActivityService.findPostByLikerId(userId);
	}
}
