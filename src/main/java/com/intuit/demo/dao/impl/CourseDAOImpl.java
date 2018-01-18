package com.intuit.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.intuit.demo.dao.CourseDAO;
import com.intuit.demo.entity.Course;
import com.intuit.demo.entity.Registration;
import com.intuit.demo.entity.User;
import com.intuit.demo.model.CourseBO;
import com.intuit.demo.util.HibernateUtil;

@Repository
public class CourseDAOImpl implements CourseDAO{

	@Autowired
    private HibernateUtil hibernateUtil;

	@Override
	public long createCourse(Course course) {

		return (Long) hibernateUtil.create(course);
	}

	@Override
	public Course updateCourse(Course course) {

		return hibernateUtil.update(course);
	
	}

	@Override
	public void deleteCourse(long id) {

		Course course = new Course();
		course.setId(id);
		hibernateUtil.delete(course);
		
	}

	@Override
	public List<Course> getAllCourses() {
    
		return hibernateUtil.fetchAll(Course.class);

	}

	@Override
	public Course getCourse(long id) {

        return hibernateUtil.fetchById(id, Course.class);

	}

	@Override
	public boolean registerCourse(long userId, long courseId) {
		boolean status = false;
		
		try {
			User user = hibernateUtil.loadById(userId, User.class);
			Course course = hibernateUtil.loadById(courseId, Course.class);
			
			Registration registration = new Registration();
			
			registration.setStatus("REGISTERED");
			registration.setCourse(course);
			registration.setUser(user);
			
			user.getRegistrations().add(registration);
			course.getRegistrations().add(registration);
			
			hibernateUtil.create(registration);
			
			status = true;
			
		} catch (Exception e) {
			status = false;
		}
		
		return status;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CourseBO> getCoursesJoinRegistrationStatusByUser(long userId) {

		List<CourseBO> resultBOList = new ArrayList<CourseBO>();
		
		String[] namedParams = {"uid"};
		Object[] params = {userId};

		List<Object[]> result = hibernateUtil.executeSelectNamedQuery("getAllCourseJoinRegistrationStatusByUser", namedParams, params);
		
		/*
		resultBOList = hibernateUtil.getSessionFactory().getCurrentSession().getNamedQuery("getAllCourseJoinRegistrationStatusByUser")
											.setParameter(namedParams[0], params[0])
											.setResultTransformer(Transformers.aliasToBean(CourseBO.class)).list();
		 */
		
		if (result != null && !result.isEmpty()){
			ListIterator<Object[]> resultItr = result.listIterator();
			
			while(resultItr.hasNext()){
				Object[] values = (Object[]) resultItr.next();
				
				CourseBO c = new CourseBO();
				c.setId( Long.parseLong(values[0].toString()) );
				c.setName( (String) values[1].toString());
				c.setFee( Float.parseFloat(values[2].toString()) ) ;
				c.setLevel( Integer.parseInt(values[3].toString()) );
				
				if (values[4] != null )
					c.setRegistrationStatus(true);
				else 
					c.setRegistrationStatus(false);
				
				resultBOList.add(c);
			}
			System.out.println(resultBOList.toString());
		}

		return resultBOList;
		
	}	

}
