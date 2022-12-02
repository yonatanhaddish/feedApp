package com.bptn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Profile\"")
@NamedQuery(name="Profile.findAll", query="SELECT p FROM Profile p")
public class Profile implements Serializable {

    @Id
    @Column(name = "\"usernameKey\"", nullable = false)
    private String username;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"usernameKey\"", nullable = false)
    @JsonBackReference
    private UserID userID;
    
    @Column(name = "\"position\"", nullable = false)
    private String position;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "\"companyAddress\"", nullable = false)
    private String companyAddress;

    @Column(name = "interests", nullable = false)
    private String interests;

    @Column(name = "experience", nullable = false)
    private String experience;

    @Column(name = "education", nullable = false)
    private String education;

    @Column(name = "certification", nullable = false)
    private String certification;

    @Column(name = "skills", nullable = false)
    private String skills;

    @Column(name = "languages", nullable = false)
    private String languages;

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCertification() {
        return certification;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UserID getUserID() {
        return userID;
    }

    public void setUserID(UserID userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = id;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "username='" + username + '\'' +
                ", userID=" + userID +
                ", position='" + position + '\'' +
                ", company='" + company + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", interests='" + interests + '\'' +
                ", experience='" + experience + '\'' +
                ", education='" + education + '\'' +
                ", certification='" + certification + '\'' +
                ", skills='" + skills + '\'' +
                ", languages='" + languages + '\'' +
                '}';
    }
}

//package com.bptn.model;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "\"Profile\"")
//public class Profile {
//	
//	@Column(name = "\"position\"")
//	private String position;
//	
//	@Column(name = "\"company\"")
//	private String company;
//	
//	@Column(name = "\"companyAddress\"")
//	private String companyAddress;
//	
//	@Column(name = "\"interests\"")
//	private String interests;
//	
//	@Column(name = "\"experience\"")
//	private String experience;
//	
//	@Column(name = "\"education\"")
//	private String education;
//	
//	@Column(name = "\"certification\"")
//	private String certification;
//	
//	@Column(name = "\"skills\"")
//	private String skills;
//	
//	@Column(name = "\"languages\"")
//	private String language;
//	
//	@Id
//	@Column(name = "\"usernameKey\"")
//	private String usernameKey;
//	
//	
//	public Profile() {
//		
//		super();
//	}
//	
//	public Profile (String position, String company, String companyAddress, String interests, String experience, String education, String certification, String skills, String language, String usernameKey) {
//		
//		super();
//		
//		this.position = position;
//		this.company = company;
//		this.companyAddress = companyAddress;
//		this.interests = interests;
//		this.experience = experience;
//		this.education = education;
//		this.certification = certification;
//		this.skills = skills;
//		this.language = language;
//		this.usernameKey = usernameKey;
//		
//	}
//
//	public String getPosition() {
//		return this.position;
//	}
//
//	public void setPosition(String position) {
//		this.position = position;
//	}
//
//	public String getCompany() {
//		return this.company;
//	}
//
//	public void setCompany(String company) {
//		this.company = company;
//	}
//
//	public String getCompanyAddress() {
//		return this.companyAddress;
//	}
//
//	public void setCompanyAddress(String companyAddress) {
//		this.companyAddress = companyAddress;
//	}
//
//	public String getInterests() {
//		return this.interests;
//	}
//
//	public void setInterests(String interests) {
//		this.interests = interests;
//	}
//
//	public String getExperience() {
//		return this.experience;
//	}
//
//	public void setExperience(String experience) {
//		this.experience = experience;
//	}
//
//	public String getEducation() {
//		return this.education;
//	}
//
//	public void setEducation(String education) {
//		this.education = education;
//	}
//
//	public String getCertification() {
//		return this.certification;
//	}
//
//	public void setCertification(String certification) {
//		this.certification = certification;
//	}
//
//	public String getSkills() {
//		return this.skills;
//	}
//
//	public void setSkills(String skills) {
//		this.skills = skills;
//	}
//
//	public String getLanguage() {
//		return this.language;
//	}
//
//	public void setLanguage(String language) {
//		this.language = language;
//	}
//
//	public String getUsernameKey() {
//		return this.usernameKey;
//	}
//
//	public void setUsernameKey(String usernameKey) {
//		this.usernameKey = usernameKey;
//	}	
//
//}
