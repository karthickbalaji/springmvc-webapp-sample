package com.intuit.demo.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.Transient;

@Entity
@Table(name = "REGISTRATION")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
        joinColumns = @JoinColumn (name = "USER_ID")),
    @AssociationOverride(name = "primaryKey.course",
        joinColumns = @JoinColumn(name = "COURSE_ID")) })
public class Registration implements Serializable{

	private static final long serialVersionUID = 9165866615211954858L;
	
	@EmbeddedId
	private UserCourseId primaryKey = new UserCourseId();
	
	@Column
    private String status;

	public Registration() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
    public UserCourseId getCompKey() {
		return primaryKey;
	}

	public void setCompKey(UserCourseId compKey) {
		this.primaryKey = compKey;
	}

	@Transient
	public User getUser() {
		return getCompKey().getUser();
	}
	
	public void setUser(User user) {
		getCompKey().setUser(user);
	}
	
	@Transient
	public Course getCourse() {
		return getCompKey().getCourse();
	}
	
	public void setCourse(Course course) {
		getCompKey().setCourse(course);
	}
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

}

	
	
