package lv.venta.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lv.venta.model.Grade;
import lv.venta.service.IUniversityFilteringService;

@Controller
@RequestMapping("/university/filter")
public class UniversityFilteringController {

	@Autowired
	private IUniversityFilteringService uniFiltService;
	
	@GetMapping("/grades/student/{id}")//localhost:8080/university/filter/grades/student/1
	public String getControllerGetallGradesForStudent(@PathVariable(name = "id") long id, Model model)
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
	
	
	
	
}
