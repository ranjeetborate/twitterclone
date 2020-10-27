package com.assignment.twitter.activity.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.assignment.twitter.posts.model.Posts;
import com.assignment.twitter.users.model.Users;
import com.assignment.twitter.utility.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="user_posts")
public class UserPosts {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private Long id;

	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="user_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Users userid;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="post_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Posts postid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getUserid() {
		return userid;
	}

	public void setUserid(Users userid) {
		this.userid = userid;
	}

	public Posts getPostid() {
		return postid;
	}

	public void setPostid(Posts postid) {
		this.postid = postid;
	}
	
}
