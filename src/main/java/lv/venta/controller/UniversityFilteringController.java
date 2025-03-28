package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.service.IUniversityFilteringService;

@Controller
@RequestMapping("/university/filter")
public class UniversityFilteringController {

	@Autowired
	private IUniversityFilteringService uniFiltService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/university/filter/grades/student/1
	public String getControllerGetAllGradesForStudent(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Grade> filteredGrades = uniFiltService.selectGradesByStudentId(id);
			model.addAttribute("box", filteredGrades);
			return "show-grades-page";//will show show-grades-page.html with filtered grades
		
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
	}
	
	
	@GetMapping("/courses/student/{id}")//localhost:8080/university/filter/courses/student/1
	public String getControllerGetAllCoursesForStudent(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Course> filteredCourses = uniFiltService.selectCoursesByStudentId(id);
			model.addAttribute("box", filteredCourses);
			return "show-courses-page";//will show show-courses-page.html with filtered grades
		
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
	}
	
	
	@GetMapping("/courses/professor/{id}")//localhost:8080/university/filter/courses/professor/1
	public String getControllerGetAllCoursesForProfessor(@PathVariable(name = "id") long id, Model model)
	{
		try {
			ArrayList<Course> filteredCourses = uniFiltService.selectCoursesByProfessorId(id);
			model.addAttribute("box", filteredCourses);
			return "show-courses-page";//will show show-courses-page.html with filtered grades
		
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
	}
	
	
	@GetMapping("/grades/course/avg/{id}")//localhost:8080/university/filter/grades/course/avg/1
	public String getControllerGetAvgGradeInCourse(@PathVariable(name = "id") long id, Model model)
	{
		try {
			float avgGrade = uniFiltService.calculateAVGGradeInCourseId(id);
			model.addAttribute("box", avgGrade);
			return "data-page";//will show data-page.html with filtered grades
		
		} catch (Exception e) {
			model.addAttribute("box", e.getMessage());
			return "error-page";//this will show error-page.html with Exception message
		}
	}
	
}
