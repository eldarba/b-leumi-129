package app.core.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

// lombok
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = { "teachers" })
@EqualsAndHashCode(of = "id")
//
@Entity
public class School {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	// owner of relationship defines join column
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	@OneToMany(mappedBy = "school"

			, fetch = FetchType.LAZY

			, cascade = { CascadeType.DETACH,

					CascadeType.MERGE,

					CascadeType.PERSIST,

					CascadeType.REFRESH })

	private List<Teacher> teachers;
	
	public void addTeacher(Teacher teacher) {
		if(this.teachers == null) {
			this.teachers = new ArrayList<>();
		}
		teacher.setSchool(this);
		this.teachers.add(teacher);
	}
	
	public void setTeachers(List<Teacher> teachers) {
		for (Teacher teacher : teachers) {
			teacher.setSchool(this);
		}
		this.teachers = teachers;
	}

}
