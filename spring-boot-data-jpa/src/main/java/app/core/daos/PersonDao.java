package app.core.daos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.core.entities.Person;

@Component
public class PersonDao {
	
	@Autowired
	private EntityManagerFactory factory;

	// CRUD actions
	public void save(Person person) {
		// === the person parameter is detached
		// create an EntityManager - persistence context object
		// a persistence context manages entities during JPA session
		EntityManager em = factory.createEntityManager();
		// start a transaction (Hibernate Session)
		em.getTransaction().begin();
		try {
			// save the person
			em.persist(person);
			// === the person parameter is now persistent
			// commit to end the transaction
			em.getTransaction().commit();
		} catch (Exception e) {
			// rollback to end the transaction
			em.getTransaction().rollback();
		}
	}
	
	
	
	
	
	
	
	
}
