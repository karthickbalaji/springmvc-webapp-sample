package com.intuit.demo.model;


import java.io.Serializable;
import java.util.List;

public class UserBO implements Serializable{

	private static final long serialVersionUID = -5732336631139241451L;

	private String name;
    
    private String email;
    
    private List<String> coursesOpted;
    

	public UserBO() {
		super();
	}

	public UserBO(String name, String email, List<String> coursesOpted) {
		super();
		this.name = name;
		this.email = email;
		this.coursesOpted = coursesOpted;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<String> getCoursesOpted() {
		return coursesOpted;
	}


	public void setCoursesOpted(List<String> coursesOpted) {
		this.coursesOpted = coursesOpted;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", email=" + email + ", coursesOpted="
				+ coursesOpted + "]";
	}


}

	
	
