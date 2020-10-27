package com.assignment.twitter.activity.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.twitter.activity.model.UserPosts;

@Repository
public interface UserPostsRepository extends CrudRepository<UserPosts, Long>{

	@Query(value = "SELECT * FROM user_posts WHERE user_id=:userId", nativeQuery = true)
	List<UserPosts> findByuserid(@Param("userId") Long userId);

	@Query(value = "SELECT * FROM user_posts WHERE post_id=:postId and user_id=:userId", nativeQuery = true)
	UserPosts checkIfPostExistsWithPostsIdAndUserId(@Param("postId") Long postId, @Param("userId") Long userId);

}
