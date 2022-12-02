package com.bptn.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "\"Role\"")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RoleId id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"usernameKey\"", nullable = false, insertable=false, updatable = false)
    @JsonBackReference
    private UserID usernameKey;

    @Column(name = "company", nullable = false)
    private String company;

    @Column(name = "skills", nullable = false)
    private String skills;

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public UserID getUsernameKey() {
        return usernameKey;
    }

    public void setUsernameKey(UserID usernameKey) {
        this.usernameKey = usernameKey;
    }

    public RoleId getId() {
        return id;
    }

    public void setId(RoleId id) {
        this.id = id;
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
//@Table(name = "\"Role\"")
//public class Role {
//	
//	@Column(name = "\"role\"")
//	private String role;
//	
//	@Column(name = "\"company\"")
//	private String company;
//	
//	@Column(name = "\"skills\"")
//	private String skills;
//	
//	@Id
//	@Column(name = "\"usernameKey\"")
//	private String usernameKey;
//	
//	
//	public Role() {
//		
//		super();
//	}
//	
//	public Role(String role, String company, String skills, String usernameKey) {
//		
//		super();
//		
//		this.role = role;
//		this.company = company;
//		this.skills = skills;
//		this.usernameKey = usernameKey;
//	}
//
//	public String getRole() {
//		return this.role;
//	}
//
//	public void setRole(String role) {
//		this.role = role;
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
//	public String getSkills() {
//		return this.skills;
//	}
//
//	public void setSkills(String skills) {
//		this.skills = skills;
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
