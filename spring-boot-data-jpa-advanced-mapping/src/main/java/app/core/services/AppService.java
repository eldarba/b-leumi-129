package app.core.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.core.entities.School;
import app.core.repos.AddressRepository;
import app.core.repos.SchoolRepository;

@Service
@Transactional
public class AppService {

	@Autowired
	private SchoolRepository schoolRepo;
	@Autowired
	private AddressRepository addressRepo;

	public int createNewSchool(School school) {
		if (!schoolRepo.existsById(school.getId())) {
			return schoolRepo.save(school).getId();
		} else {
			throw new RuntimeException("school already exists");
		}
	}

	public School getSchool(int id) {
		return this.schoolRepo.findById(id)

				.orElseThrow(() -> new RuntimeException("not found"));
	}

	public void updateSchool(School school) {
		if (schoolRepo.existsById(school.getId())) {
			schoolRepo.save(school);
		} else {
			throw new RuntimeException("school not exists");
		}
	}
	
	public void deleteSchool(int id) {
		schoolRepo.deleteById(id);
	}

}
