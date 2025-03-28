package lv.venta.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import lv.venta.model.Student;

public interface IStudentRepo extends CrudRepository<Student, Long> {

	public abstract ArrayList<Student> findByGradesGrvalueLessThan(int i);

}
