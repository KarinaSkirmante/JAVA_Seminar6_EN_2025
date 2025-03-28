package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lv.venta.model.enums.Degree;
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "ProfessorTable")//MySql - professor_table
@Entity
public class Professor extends Person {
	@Column(name = "PId")
	@Setter(value = AccessLevel.NONE)//will remove setter for id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long pid;
	
	
	@NotNull
	@Column(name = "Degree")
	@Enumerated(EnumType.STRING)
	private Degree degree;
	
	@OneToOne(mappedBy = "professor")//need to point which variable is with @JoinColumn
	@ToString.Exclude
	private Course course;
	
	public Professor(String inputName, String inputSurname, Degree inputDegree)
	{
		super(inputName, inputSurname);
		setDegree(inputDegree);
	}
}
