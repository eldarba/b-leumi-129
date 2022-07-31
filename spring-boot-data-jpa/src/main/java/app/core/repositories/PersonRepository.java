package app.core.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

	// add custom methods - queries are derived by method name
	List<Person> findByAgeLessThan(int age);
}
