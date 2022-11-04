package com.bptn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"History\"")
public class History {
	
	@Id
	@Column(name = "\"postID\"")
	private String postID;
	
	@Column(name = "\"usernameKey\"")
	private String usernameKey;
	
	@Column(name = "\"date\"")
	private String date;
	
	@Column(name = "\"postType\"")
	private String postType;
	
	@Column(name = "\"postUpload\"")
	private String postUpload;
	
	
	public History() {
		
		super();
	}
	
	public History(String postID, String usernameKey, String date, String postType, String postUpload) {
		
		super();
		
		this.postID = postID;
		this.usernameKey = usernameKey;
		this.date = date;
		this.postType = postType;
		this.postUpload = postUpload;
	}

	public String getPostID() {
		return this.postID;
	}

	public void setPostID(String postID) {
		this.postID = postID;
	}

	public String getUsernameKey() {
		return this.usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}

	public String getDate() {
		return this.date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getPostType() {
		return this.postType;
	}

	public void setPostType(String postType) {
		this.postType = postType;
	}

	public String getPostUpload() {
		return this.postUpload;
	}

	public void setPostUpload(String postUpload) {
		this.postUpload = postUpload;
	}
	
}
