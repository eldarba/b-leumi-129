package app.core.services;

import java.util.List;

import app.core.entities.Person;

public interface PersonService {

	int createPerson(Person person);

	Person getPerson(int id);

	List<Person> getAll();

	void updatePerson(Person person);

	void deletePerson(int id);
}
