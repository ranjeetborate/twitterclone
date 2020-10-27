package com.assignment.twitter.followers.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.assignment.twitter.followers.model.Followers;
import com.assignment.twitter.users.model.Users;

@Repository
public interface FollowersRepository extends CrudRepository<Followers, Long>{

	@Query(value = "SELECT * FROM followers WHERE user_id=:userId", nativeQuery = true)
	List<Followers> fetchFollowedPeoplesPostsByUserId(@Param("userId") Long userId);

}
