package com.bptn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Role\"")
public class Role {
	
	@Column(name = "\"role\"")
	private String role;
	
	@Column(name = "\"company\"")
	private String company;
	
	@Column(name = "\"skills\"")
	private String skills;
	
	@Id
	@Column(name = "\"usernameKey\"")
	private String usernameKey;
	
	
	public Role() {
		
		super();
	}
	
	public Role(String role, String company, String skills, String usernameKey) {
		
		super();
		
		this.role = role;
		this.company = company;
		this.skills = skills;
		this.usernameKey = usernameKey;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getUsernameKey() {
		return this.usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}
	
}
