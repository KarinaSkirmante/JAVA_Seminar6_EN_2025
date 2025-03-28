package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Long>{

	//Data JPA will create SQL query:
	//SELECT T2.cid, T2.title, T2.credit_points, T2.pid FROM grade_table as T1 JOIN course_table as T2 ON T1.cid=T2.cid WHERE T1.
	//sid = ?1;
	//?1 - > the first input param
	public abstract ArrayList<Course> findByGradesStudentPeid(long id);

	
	//Data JPA will create SQL query:\
	//SELECT * FROM course_table WHERE pid = ?1;
	//?1 - > the first input param
	public abstract ArrayList<Course> findByProfessorPeid(long id);

}
