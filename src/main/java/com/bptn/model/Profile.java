package com.bptn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"Profile\"")
public class Profile {
	
	@Column(name = "\"position\"")
	private String position;
	
	@Column(name = "\"company\"")
	private String company;
	
	@Column(name = "\"companyAddress\"")
	private String companyAddress;
	
	@Column(name = "\"interests\"")
	private String interests;
	
	@Column(name = "\"experience\"")
	private String experience;
	
	@Column(name = "\"education\"")
	private String education;
	
	@Column(name = "\"certification\"")
	private String certification;
	
	@Column(name = "\"skills\"")
	private String skills;
	
	@Column(name = "\"languages\"")
	private String language;
	
	@Id
	@Column(name = "\"usernameKey\"")
	private String usernameKey;
	
	
	public Profile() {
		
		super();
	}
	
	public Profile (String position, String company, String companyAddress, String interests, String experience, String education, String certification, String skills, String language, String usernameKey) {
		
		super();
		
		this.position = position;
		this.company = company;
		this.companyAddress = companyAddress;
		this.interests = interests;
		this.experience = experience;
		this.education = education;
		this.certification = certification;
		this.skills = skills;
		this.language = language;
		this.usernameKey = usernameKey;
		
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyAddress() {
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getInterests() {
		return this.interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getExperience() {
		return this.experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getEducation() {
		return this.education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCertification() {
		return this.certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public String getSkills() {
		return this.skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getLanguage() {
		return this.language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getUsernameKey() {
		return this.usernameKey;
	}

	public void setUsernameKey(String usernameKey) {
		this.usernameKey = usernameKey;
	}	

}
