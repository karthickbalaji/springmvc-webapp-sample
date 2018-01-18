package com.intuit.demo.model;


import java.io.Serializable;

public class CourseBO implements Serializable{

	private static final long serialVersionUID = -5103297203873022240L;

	private long id;
	
    private String name;
    
    private float fee;
    
    private int level;
    
    private boolean registrationStatus;

	public CourseBO() {
		super();
	}

	public CourseBO(long id, String name, int fee, int level) {
		super();
		this.setId(id);
		this.name = name;
		this.fee = fee;
		this.level = level;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getFee() {
		return fee;
	}

	public void setFee(float fee) {
		this.fee = fee;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public long getId() {
		return id;
	}

	public void setId(long courseId) {
		this.id = courseId;
	}

	@Override
	public String toString() {
		return "CourseBO [courseId=" + id + ", name=" + name + ", fee="
				+ fee + ", level=" + level + ", registrationStatus="
				+ registrationStatus + "]";
	}

	public boolean getRegistrationStatus() {
		return registrationStatus;
	}

	public void setRegistrationStatus(boolean status) {
		this.registrationStatus = status;
	}
	
}

	
	
