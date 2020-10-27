package com.assignment.twitter.activity.dao;

import java.util.List;
import java.util.Optional;

import com.assignment.twitter.activity.model.PostsActivity;

public interface IPostsActivityDao {

	PostsActivity likePost(PostsActivity postsActivityJson);

	PostsActivity dislikePost(PostsActivity postsActivityJson);

	List<PostsActivity> findPostByLikerId(Long userId);

	Optional<PostsActivity> findById(Long id);

	PostsActivity findPostActivityByWhoIdAndPostIdAndWhoseId(Long whoId, Long postId, Long whoseId);

	PostsActivity findPostActivityByPostIdAndWhoseId(Long postId, Long whoseId);

	List<PostsActivity> findAllLikedPostsByUserId(Long id);

}
