package app.core.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Person;
import app.core.services.PersonService;

@Component
@Order(3)
public class Runner3 implements CommandLineRunner {

	@Autowired
	private PersonService service;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============ Runner 3");
		try {
			doCreate();
//			doRead(6);
//			doReadAll();
			doReadYungerThan(15);
//			service.updatePerson(new Person(5, "Moshe", 18));
//			service.deletePerson(5);
		} catch (Exception e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
	
	
	void doReadAll() {
		List<Person> list = service.getAll();
		System.out.println("All Persons =======================");
		for (Person person : list) {
			System.out.println(person);
		}
		System.out.println("===================================");
	}
	void doReadYungerThan(int age) {
		List<Person> list = service.getPersonYungerThan(age);
		System.out.println("All Persons ynger  than " + age + " ===");
		for (Person person : list) {
			System.out.println(person);
		}
		System.out.println("===================================");
	}
	
	void doRead(int id) {
		Person p = service.getPerson(id);
		System.out.println(p);
	}
	
	void doCreate() { 
		Person p = new Person(0, "Eithan", 8);
		int id = service.createPerson(p);
		System.out.println("created: " + id);
	}

}
