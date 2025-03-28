package lv.venta.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "StudentTable")//MySql - student_table
@Entity
public class Student extends Person{
	@Column(name = "SId")
	@Setter(value = AccessLevel.NONE)//will remove setter for id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long sid;
	
	
	
	@OneToMany(mappedBy = "student")
	@ToString.Exclude
	private Collection<Grade> grades;
	
	public Student(String name, String surname) {
		super(name, surname);
	}

}
