package app.core.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.core.entities.Person;
import app.core.repositories.PersonRepository;

@Service
@Transactional // each method in this class is a transaction
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository repo;

	@Override
	public int createPerson(Person person) {
		if (!repo.existsById(person.getId())) {
			person = repo.save(person);
			return person.getId();
		}
		throw new RuntimeException("createPerson failed - already exists");
	}

	@Override
	public Person getPerson(int id) {
		return repo.findById(id).orElseThrow(
				() -> new RuntimeException("getPerson failed - not found"));
	}

	@Override
	public List<Person> getAll() {
		return repo.findAll();
	}

	@Override
	public void updatePerson(Person person) {
		if (repo.existsById(person.getId())) {
			repo.save(person);
		}
		throw new RuntimeException("updatePerson failed - not exists");
	}

	@Override
	public void deletePerson(int id) {
		repo.deleteById(id);
	}

}
