package com.bptn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Post\"")
public class Post {
	
	@Id
	@Column(name = "\"postID\"")
	private String postID;
	
	@Column(name = "\"postType\"")
	private String postType;
	
	@Column(name = "\"post\"")
	private String post;
	
	@Column(name = "\"usernameKey\"")
	private String usernameKey;
	
	
	public Post() {
		super();
	}
	
	public Post(String postID, String postType, String post, String usernameKey) {
		
		super();
		this.postID = postID;
		this.postType = postType;
		this.post = post;
		this.usernameKey = usernameKey;
	}
	
	public String getPostID() {
		return this.postID;
	}
	public void setPostID(String postID) {
		this.postID = postID;
	}
	
	public String getPostType() {
		return this.postType;
	}
	public void setPostType(String postType) {
		this.postType = postType;
	}
	
	public String getPost() {
		return this.post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	
	public String getUserNameKey() {
		return this.usernameKey;
	}
	public void setUserNameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

}
