package com.bptn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name = "\"UserID\"")
@NamedQuery(name="UserID.findAll", query="SELECT u FROM UserID u")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class UserID implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "\"emailID\"", nullable = false)
    private String emailID;

    @Column(name = "\"phoneNumber\"", nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "usernameKey", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Role> roles = new LinkedHashSet<>();

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "userID")
    @JsonManagedReference
    private Profile profile;

    @OneToMany(mappedBy = "usernameKey", cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Address> addresses = new LinkedHashSet<>();

    public Set<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String id) {
        this.username = id;
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
//@Table(name = "\"UserID\"")
//public class UserID {
//	
//	@Column(name = "\"name\"")
//	private String name;
//	
//	@Column(name = "\"emailID\"")
//	private String emailID;
//	
//	@Column(name = "\"phoneNumber\"")
//	private String phoneNumber;
//	
//	@Column(name = "\"userPassword\"")
//	private String userPassword;
//	
//	@Id
//	@Column(name = "\"username\"")
//	private String username;
//	
////	constructor
//	public UserID() {
//		super();
//	}
////	constructor with parameters
//	public UserID(String name, String emailID, String phoneNumber, String userPassword, String username) {
//		
//		super();
//		this.name = name;
//		this.emailID = emailID;
//		this.phoneNumber = phoneNumber;
//		this.userPassword = userPassword;
//		this.username = username;
//	}
////	getter method for getting name
//	public String getName() {
//		return this.name;
//	}
////	setter method for setting a name
//	public void setName(String name) {
//		this.name = name;
//	}
////	getter method for getting an emailID
//	public String getEmailID() {
//		return this.emailID;
//	}
////	setter method for setting an emailID
//	public void setEmailID(String emailID) {
//		this.emailID = emailID;
//	}
////	getter method for getting a phone number
//	public String getPhoneNumber() {
//		return this.phoneNumber;
//	}
////	setter method for setting a phone number
//	public void setPhoneNumber(String phoneNumber) {
//		this.phoneNumber = phoneNumber;
//	}
////	getter method for getting a password
//	public String getPassword() {
//		return this.userPassword;
//	}
////	setter for setting a password
//	public void setPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
////	getter method for getting a username
//	public String getUsername() {
//		return this.username;
//	}
////	setter method for setting a username
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	
//}
