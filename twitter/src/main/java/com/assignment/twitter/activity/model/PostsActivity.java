package com.assignment.twitter.activity.model;

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
import com.assignment.twitter.utility.Views.BasicView;
import com.assignment.twitter.utility.Views.LikedPostsView;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="posts_activity")
public class PostsActivity extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="who_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Users whoid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="whose_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	private Users whoseid;
	
	@ManyToOne
	@JoinColumn(name="post_id",nullable=false)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) 
	@JsonView({LikedPostsView.class})
	private Posts postid;

	@Column(name="like_dislike_status")
	private Integer likedislikestatus; 
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Users getWhoid() {
		return whoid;
	}

	public void setWhoid(Users whoid) {
		this.whoid = whoid;
	}

	public Users getWhoseid() {
		return whoseid;
	}

	public void setWhoseid(Users whoseid) {
		this.whoseid = whoseid;
	}

	public Posts getPostid() {
		return postid;
	}

	public void setPostid(Posts postid) {
		this.postid = postid;
	}

	public Integer getLikedislikestatus() {
		return likedislikestatus;
	}

	public void setLikedislikestatus(Integer likedislikestatus) {
		this.likedislikestatus = likedislikestatus;
	}
	
}
