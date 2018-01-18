package com.intuit.demo;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intuit.demo.model.CourseBO;
import com.intuit.demo.model.RegisterCourseInfo;
import com.intuit.demo.service.CourseService;

/**
 * Handles requests for the course application page.
 */
@Controller 
@RequestMapping("/api")
public class CourseController {
	
	private static final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	@Autowired
	CourseService courseService;

	@RequestMapping(value = "/courses/{uid}", method = RequestMethod.GET)
	@ResponseBody
	public List<CourseBO> getCourses(@PathVariable("uid") long userId) {
		logger.info("CourseController :: getCourses()");
		
		List<CourseBO> courses = courseService.getAllCoursesWithStatus(userId);

		return courses;
		/*return courses.stream()
        .map(courseDTO -> DTOEntityConverter.convertToDTO(courseDTO))
        .collect(Collectors.toList());
		*/
	}

	@RequestMapping(value = "/course/register", method = RequestMethod.POST, produces="text/plain")
	@ResponseBody
	public String registerCourse(@RequestBody RegisterCourseInfo regCourseInfo, HttpServletRequest request,
            HttpServletResponse response) {
		
		logger.info("CourseController :: registerCourse()");
		
		if (courseService.registerCourse(regCourseInfo.getUserId(), regCourseInfo.getCourseId()) ) {
			return "success";
		} else 
			return "fail";

	}

}
