package com.assignment.twitter.activity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.twitter.activity.model.PostsActivity;

@Repository
public interface PostsActivityRepository extends CrudRepository<PostsActivity, Long>{

	@Query(value = "SELECT * FROM posts_activity WHERE who_id=:userId", nativeQuery = true)
	List<PostsActivity> findBywhoid(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM posts_activity WHERE who_id=:whoId and post_id=:postId and whose_id=:whoseId", nativeQuery = true)
	PostsActivity findPostActivityByWhoIdAndPostIdAndWhoseId(@Param("whoId") Long whoId, @Param("postId") Long postId, @Param("whoseId") Long whoseId);

	@Query(value = "SELECT * FROM posts_activity WHERE post_id=:postId and whose_id=:whoseId", nativeQuery = true)
	PostsActivity findPostActivityByPostIdAndWhoseId(@Param("postId") Long postId, @Param("whoseId") Long whoseId);

	@Query(value = "SELECT * FROM posts_activity pa WHERE who_id=:userId", nativeQuery = true)
	List<PostsActivity> findAllLikedPostsByUserId(@Param("userId") Long userId);

}
