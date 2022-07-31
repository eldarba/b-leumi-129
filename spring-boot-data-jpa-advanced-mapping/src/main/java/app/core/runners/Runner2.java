package app.core.runners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.entities.Teacher;
import app.core.services.AppService;

@Component
@Order(2)
public class Runner2 implements CommandLineRunner {
	@Autowired
	private AppService appService;

	@Override
	public void run(String... args) throws Exception {
		try {
			doCreateNewSchool();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}

	void doCreateNewSchool() {
		School school1 = new School(0, "Scholl-A", new Address(0, "Israel", "Haifa", "Begin", 25, null),null);
		School school2 = new School(0, "Scholl-B", new Address(0, "Zfat", "Haifa", "Begin", 25, null),null);
	
		List<Teacher> teachers1 = new ArrayList<>();
		teachers1.add(new Teacher(0, "aaa", "052-111-111", null));
		teachers1.add(new Teacher(0, "bbb", "052-111-111", null));
		teachers1.add(new Teacher(0, "ccc", "052-111-111", null));
		school1.setTeachers(teachers1);
		
		List<Teacher> teachers2 = new ArrayList<>();
		teachers2.add(new Teacher(0, "ddd", "052-111-111", null));
		teachers2.add(new Teacher(0, "eee", "052-111-111", null));
		school2.setTeachers(teachers2);
		
		
		appService.createNewSchool(school1);
		appService.createNewSchool(school2);
	}

	void doUpdateSchool(School school) {
		school.setName("The-Arts-School");
		Address address = school.getAddress();
		address.setCity("Tel Aviv");
		address.setNumber(150);
		address.setStreet("Herzel");
		appService.updateSchool(school);

	}

	School doGetSchool(int id) {
		School school = appService.getSchool(id);
		System.out.println(school);
		System.out.println(school.getAddress());
		return school;
	}

}
