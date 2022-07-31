package app.core.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import app.core.entities.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {

}
