package lv.venta.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lv.venta.model.Course;
import lv.venta.model.Grade;
import lv.venta.model.Student;
import lv.venta.repo.IGradeRepo;
import lv.venta.repo.IStudentRepo;
import lv.venta.service.IUniversityFilteringService;

@Service
public class UniversityFilteringServiceImpl implements IUniversityFilteringService{

	@Autowired
	private IStudentRepo studRepo;
	
	@Autowired
	private IGradeRepo grRepo;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Course> selectCoursesByProfessorId(long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateAVGGradeInCourseId(long id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Student> selectStudentsWithFailedGrades() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
