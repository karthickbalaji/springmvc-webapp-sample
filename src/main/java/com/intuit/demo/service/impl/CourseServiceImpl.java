package com.intuit.demo.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intuit.demo.dao.CourseDAO;
import com.intuit.demo.entity.Course;
import com.intuit.demo.model.CourseBO;
import com.intuit.demo.service.CourseService;


@Service
@Transactional
public class CourseServiceImpl implements CourseService {
	
	public CourseServiceImpl() {
		System.out.println("CourseServiceImpl()");		
	}
	
    @Autowired
    private CourseDAO courseDAO;

	@Override
	public long createCourse(Course course) {

		return courseDAO.createCourse(course);
	}
	
	@Override
	public Course updateCourse(Course course) {

		return courseDAO.updateCourse(course);
	}
	
	@Override
	public void deleteCourse(long id) {
		courseDAO.deleteCourse(id);
	}
	
	@Override
	public List<Course> getAllCourses() {
		return courseDAO.getAllCourses();
	}
	
	@Override
	public Course getCourse(long id) {
		return courseDAO.getCourse(id);
	}

	@Override
	public boolean registerCourse(long userId, long courseId) {

		return courseDAO.registerCourse(userId, courseId);
		
	}

	@Override
	public List<CourseBO> getAllCoursesWithStatus(long userId) {
		
		return courseDAO.getCoursesJoinRegistrationStatusByUser(userId);
	}
}
