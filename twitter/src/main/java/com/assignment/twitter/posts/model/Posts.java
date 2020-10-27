package com.assignment.twitter.posts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.assignment.twitter.utility.BaseEntity;
import com.assignment.twitter.utility.Views.BasicView;
import com.assignment.twitter.utility.Views.LikedPostsView;
import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(name="posts")
public class Posts extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	@Column(name="id")
	@JsonView({LikedPostsView.class})
	private Long id;

	@Column(name="post_content")
	@JsonView({LikedPostsView.class})
	private String postcontent;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostcontent() {
		return postcontent;
	}

	public void setPostcontent(String postcontent) {
		this.postcontent = postcontent;
	}
		
}
