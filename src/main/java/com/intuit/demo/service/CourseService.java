package com.intuit.demo.service;

import java.util.List;

import com.intuit.demo.entity.Course;
import com.intuit.demo.model.CourseBO;


public interface CourseService {

	public long createCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(long id);
    public List<Course> getAllCourses();
    public Course getCourse(long id);
    
	public boolean registerCourse(long userId, long courseId);
	public List<CourseBO> getAllCoursesWithStatus(long userId);	

}
