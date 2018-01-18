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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
@NamedNativeQueries({
	@NamedNativeQuery(name = "getAllCourseJoinRegistrationStatusByUser", query ="select c.course_id, c.name, c.fee, c.level, r.status from Course c left join Registration r on c.course_id = r.course_id and r.user_id = :uid" )
})
public class Course implements Serializable{

	private static final long serialVersionUID = -1823866310524088863L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "COURSE_ID")
    private long id;
	
    @Column
    private String name;
    
    @Column
    private float fee;
    
    @Column
    private int level;
    
    @OneToMany (mappedBy = "primaryKey.course",
    				cascade = CascadeType.ALL)  
    private Set<Registration> registrations = new HashSet<Registration>();

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(String name, int fee, int level) {
		super();
		this.name = name;
		this.fee = fee;
		this.level = level;
	}

	public Course(long id, String name, int fee, int level) {
		super();
		this.id = id;
		this.name = name;
		this.fee = fee;
		this.level = level;
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

	public Set<Registration> getRegistrations() {
		return registrations;
	}

	public void setRegistrations(Set<Registration> registrations) {
		this.registrations = registrations;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", fee=" + fee
				+ ", level=" + level + ", registrations=" + registrations + "]";
	}


}

	
	
