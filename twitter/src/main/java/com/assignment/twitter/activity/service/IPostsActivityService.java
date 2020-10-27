package com.assignment.twitter.activity.service;

import java.util.List;

import com.assignment.twitter.activity.model.PostsActivity;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.utility.customexceptions.BusinessException;

public interface IPostsActivityService {

	PostsActivity dislikePost(PostsActivity postsActivityJson);

	List<PostsActivity> findPostByLikerId(Long userId) throws BusinessException;

	PostsActivity likePost(Integer status, Long whoId, Long whoseId, Long postId) throws BusinessException;

	List<Posts> findAllLikedPostsByUserId(Long userId) throws BusinessException;

}
