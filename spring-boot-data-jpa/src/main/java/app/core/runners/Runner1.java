package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.daos.PersonDao;
import app.core.entities.Person;

@Component
@Order(1)
public class Runner1 implements CommandLineRunner {

	@Autowired
	private PersonDao dao;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Runner 1");
		Person p = new Person(0, "David", 25);
		dao.save(p);

//		PersonRepository repo = ctx.getBean(PersonRepository.class);
//		p = repo.save(p);
//		System.out.println(p);
	}

}
