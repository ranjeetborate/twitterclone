package com.assignment.twitter.posts.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.twitter.posts.model.Posts;

@Repository
public interface PostsRepository extends CrudRepository<Posts, Long>{

}
