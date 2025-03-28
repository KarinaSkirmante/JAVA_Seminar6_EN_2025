package lv.venta.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@MappedSuperclass
public class Person {

	
	@Column(name = "Name")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,15}")
	private String name;
	
	@Column(name = "Surname")
	@NotNull
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,30}")
	private String surname;
	
	public Person(String name, String surname)
	{
		setName(name);
		setSurname(surname);
	}
	
}
