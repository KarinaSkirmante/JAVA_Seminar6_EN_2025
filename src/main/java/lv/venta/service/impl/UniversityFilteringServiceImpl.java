package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.ICourseRepo;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IProfessorRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IUniversityFilteringService;

@Service
public class UniversityFilteringServiceImpl implements IUniversityFilteringService{

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
	@Autowired
	private ICourseRepo couRepo;
	
	@Autowired
	private IProfessorRepo profRepo;
	
	@Override
	public ArrayList<Grade> selectGradesByStudentId(long id) throws Exception {
		if(id < 1)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!studRepo.existsById(id))
		{
			throw new Exception("Student with id: " + id + " doesn't exist");
		}
		
		ArrayList<Grade> result = grRepo.findByStudentSid(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no grade for student with id: " + id);
		}

		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(long id) throws Exception {
		
		if(id < 1)
		{
			throw new Exception("Id should be positive");
		}
		if(!studRepo.existsById(id))
		{
			throw new Exception("Student with id: " + id + " doesn't exist");
		}
		ArrayList<Course> result = couRepo.findByGradesStudentSid(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no course linked to student with id: " + id);
		}

		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		if(id < 1)
		{
			throw new Exception("Id should be positive");
		}
		if(!profRepo.existsById(id))
		{
			throw new Exception("Professor with id: " + id + " doesn't exist");
		}
		
		ArrayList<Course> result = couRepo.findByProfessorPid(id);
		
		if(result.isEmpty())
		{
			throw new Exception("There is no course linked to professor with id: " + id);
		}
		
		return result;
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception {
		if(id < 1)
		{
			throw new Exception("Id should be positive");
		}
		
		if(!couRepo.existsById(id)) {
			throw new Exception("Course with id: " + id + " doesn't exist");
		}
		
		
		float result = grRepo.calculateAVGGradeFromDB(id);
		
		if(result == 0) {
			throw new Exception("There is no grade linked to course with id: " + id);
		}
				
		return result;
	}

	@Override
	public ArrayList<Student> selectStudentsWithFailedGrades() throws Exception {
		

		ArrayList<Student> result = studRepo.findByGradesGrvalueLessThan(4);
		
		if(result.isEmpty())
		{
			throw new Exception("There is failed grades");
		}
		
		return result;
	}

}
