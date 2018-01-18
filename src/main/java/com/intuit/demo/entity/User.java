package com.intuit.demo.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@NamedQueries(value = { 
		@NamedQuery(name = "findByUserNameAndPwd", query = "select u from User u where u.name = :username and u.password = :password") 
		})
public class User implements Serializable{


	private static final long serialVersionUID = 6713588636361973679L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column (name="USER_ID")
    private long id;
	
    @Column
    private String name;
    
    @Column
    private String password;
    
    @Column
    private String email;
    
    @OneToMany(mappedBy = "primaryKey.user",
    			cascade = CascadeType.ALL)
    private Set<Registration> registrations = new HashSet<Registration>();


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public User(String name, String password, String email) {
		super();
		this.name = name;
		this.password = password;
		this.email = email;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Registration> getRegistrations() {
		return registrations;
	}


	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", password=" + password
				+ ", email=" + email + ", registrations=" + registrations + "]";
	}

}

	
	
