package com.assignment.twitter.activity.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.assignment.twitter.activity.dao.IPostsActivityDao;
import com.assignment.twitter.activity.model.PostsActivity;
import com.assignment.twitter.activity.repo.PostsActivityRepository;

@Component
public class PostsActivityDaoImpl implements IPostsActivityDao{

	@Autowired
	private PostsActivityRepository postsActivityRepository;
	
	@Override
	public PostsActivity likePost(PostsActivity postsActivityJson) {
		return postsActivityRepository.save(postsActivityJson);
	}

	@Override
	public PostsActivity dislikePost(PostsActivity postsActivityJson) {
		return postsActivityRepository.save(postsActivityJson);
	}

	@Override
	public List<PostsActivity> findPostByLikerId(Long userId) {
		System.out.println("findPostByLikerId "+userId);
		return postsActivityRepository.findBywhoid(userId);
	}

	@Override
	public Optional<PostsActivity> findById(Long id){
		return postsActivityRepository.findById(id);
	}

	@Override
	public PostsActivity findPostActivityByWhoIdAndPostIdAndWhoseId(Long whoId, Long postId, Long whoseId) {
		return postsActivityRepository.findPostActivityByWhoIdAndPostIdAndWhoseId(whoId, postId, whoseId);
	}

	@Override
	public PostsActivity findPostActivityByPostIdAndWhoseId(Long postId, Long whoseId) {
		return postsActivityRepository.findPostActivityByPostIdAndWhoseId(postId, whoseId);
	}

	@Override
	public List<PostsActivity> findAllLikedPostsByUserId(Long id) {
		return postsActivityRepository.findAllLikedPostsByUserId(id);
	}
}
