package com.assignment.twitter.activity.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.twitter.activity.dao.IPostsActivityDao;
import com.assignment.twitter.activity.dao.IUserPostsDao;
import com.assignment.twitter.activity.model.PostsActivity;
import com.assignment.twitter.activity.model.UserPosts;
import com.assignment.twitter.activity.service.IPostsActivityService;
import com.assignment.twitter.posts.dao.IPostsDao;
import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.users.dao.IUsersDao;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.utility.customexceptions.BusinessException;

@Service
public class PostsActivityServiceImpl implements IPostsActivityService{

	@Autowired
	private IPostsActivityDao postsActivityDao;
	
	@Autowired
	private IPostsDao postsDao;

	@Autowired
	private IUsersDao usersDao;

	@Autowired
	private IUserPostsDao userPostsDao;

	@Override
	public PostsActivity likePost(Integer status, Long whoId, Long whoseId, Long postId) throws BusinessException {
		Users whoUser = null;
		Posts post = null;
		Users whoseUser =null;
		
		try {
			Optional<Posts> optionalPost = postsDao.findPostById(postId);
			post = optionalPost.get();
		}catch(Exception e) {
			throw new BusinessException("No such post exist with the provided post id");			
		}
		
		try {
			Optional<Users> optionalWhoUser = usersDao.findById(whoId);
			whoUser = optionalWhoUser.get();	
		}catch(Exception e) {
			throw new BusinessException("No such user is present");
		}
		
		try {
			Optional<Users> optionalWhoseUser = usersDao.findById(whoseId);
			whoseUser = optionalWhoseUser.get();
		}catch(Exception e) {
			throw new BusinessException("No such user is present. Please check whether the specified user id exists or not");					
		}
		
		if(post != null && whoUser!=null && whoseUser!=null) {
			PostsActivity postAcvitity = postsActivityDao.findPostActivityByPostIdAndWhoseId(post.getId(), whoseUser.getId());
			UserPosts userPost = userPostsDao.checkIfPostExistsWithPostsIdAndUserId(post.getId(), whoseUser.getId());
			if(userPost != null) {
				if(postAcvitity!=null) {
					if(postAcvitity.getLikedislikestatus()==1)
						postAcvitity.setLikedislikestatus(2);
					else if(postAcvitity.getLikedislikestatus()==2)
						postAcvitity.setLikedislikestatus(1);
					return postsActivityDao.likePost(postAcvitity);														
				}else {
					PostsActivity createPostActivity = new PostsActivity();
					createPostActivity.setWhoid(whoUser);
					createPostActivity.setWhoseid(whoseUser);
					createPostActivity.setPostid(post);
					createPostActivity.setLikedislikestatus(1);
					return postsActivityDao.likePost(createPostActivity);															
				}
			} else {
				throw new BusinessException("No any post found for the user "+whoseUser.getUsername());
			}
		}else {
			throw new BusinessException("Something went wrong");
		}
	}

	@Override
	public PostsActivity dislikePost(PostsActivity postsActivityJson) {
		return postsActivityDao.dislikePost(postsActivityJson);
	}

	@Override
	public List<PostsActivity> findPostByLikerId(Long userId) throws BusinessException {
		try {
			Optional<Users> optionalUser = usersDao.findById(userId);
			Users whoUser = optionalUser.get();	
			List<PostsActivity> likedPosts = postsActivityDao.findPostByLikerId(whoUser.getId());
			return likedPosts;
		}catch(Exception e) {
			throw new BusinessException("No such user is present");			
		}
	}

	@Override
	public List<Posts> findAllLikedPostsByUserId(Long userId) throws BusinessException {
		List<Posts> posts = new ArrayList();
		List<PostsActivity> postsActivityList = postsActivityDao.findAllLikedPostsByUserId(userId);
		for(PostsActivity pa : postsActivityList) {
			posts.add(pa.getPostid());
		}
		return posts;
	}
}
