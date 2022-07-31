package app.core.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.School;
import app.core.services.AppService;

@Component
@Order(1)
public class Runner1 implements CommandLineRunner {
	@Autowired
	private AppService appService;

	@Override
	public void run(String... args) throws Exception {
		try {
//			doCreateNewSchool();
//			School school = doGetSchool(1);
//			doUpdateSchool(school);
//			appService.deleteSchool(1);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
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

	void doCreateNewSchool() {
		School school = new School(0, "JBT", new Address(0, "Israel", "Jerusalem", "Begin", 25, null));
		appService.createNewSchool(school);
	}

}
