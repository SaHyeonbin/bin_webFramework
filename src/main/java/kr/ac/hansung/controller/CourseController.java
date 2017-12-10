package kr.ac.hansung.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/course")
	public String showCourse(Model model) {
		List<Course> courses = courseService.getYearSeme();
		List<Course> diviCourse = courseService.getDivi();
		model.addAttribute("courses", courses);
		model.addAttribute("divi", diviCourse);
		return "courses";
	}
	@RequestMapping("/detail")
	public String showDetail(@RequestParam int year, @RequestParam int seme, Model model) {
		List<Course> courses = courseService.getYearSemeCourses(year, seme);
		model.addAttribute("courses", courses);
		return "detail";
	}
}
