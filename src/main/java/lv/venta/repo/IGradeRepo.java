package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Long>{

	//Data JPA will create SQL query:
	//SELECT * FROM grade_table WHERE sid = ?1;
	//?1 -> the first param in function
	public abstract ArrayList<Grade> findByStudentSid(long id);

	@Query(nativeQuery = true, value = "SELECT avg(gr_value) FROM grade_table WHERE cid = ?1;")
	public abstract float calculateAVGGradeFromDB(long id);

}
