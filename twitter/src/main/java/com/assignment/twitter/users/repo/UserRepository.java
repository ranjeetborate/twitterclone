package com.assignment.twitter.users.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.assignment.twitter.users.model.Users;

@Repository
public interface UserRepository extends CrudRepository<Users, Long>{

	Users findUserByusername(String username);

	List<Users> findUserByusernameContaining(String username);

}
