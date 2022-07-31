package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Person;
import app.core.repositories.PersonRepository;

//@Component
@Order(2)
public class Runner2 implements CommandLineRunner {

	@Autowired
	private PersonRepository repo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner 2");
		Person p = new Person(0, "David", 25);
		p = repo.save(p);
		System.out.println(p);
	}

}
