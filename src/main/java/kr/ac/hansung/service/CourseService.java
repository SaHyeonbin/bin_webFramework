package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDAO;
import kr.ac.hansung.model.Course;
@Service
public class CourseService {
	
	@Autowired
	private  CourseDAO courseDAO;
	
	public  List<Course> getYearSeme() {
		return courseDAO.getCourseYearSeme();
	}
	public  List<Course> getYearSemeCourses(int year, int seme) {
		return courseDAO.getCoursesYearSeme(year, seme); 
	}
	public  List<Course> getDivi() {
		return courseDAO.getCourseDivi();
	}
	public int getSumGrade() {
		return courseDAO.getSumGrade();
	}
}
