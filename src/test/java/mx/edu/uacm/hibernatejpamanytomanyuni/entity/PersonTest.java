package mx.edu.uacm.hibernatejpamanytomanyuni.entity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
public class PersonTest {
	
	private static final Logger log = LogManager.getLogger(PersonTest.class);
	
	@PersistenceContext
	private EntityManager em;
	
	@Test
	@Transactional
	@Rollback(false)
	public void debeGuardarPersonyAddress() {
		log.debug(">Entrando al metodo debeGuardarPersonyAddress<");
		
		Person person1 = new Person();
		Person person2 = new Person();

		Address address1 = new Address( "Calle", "11" );
		Address address2 = new Address( "Av. de la Constitución", "1" );

		person1.getAddresses().add(address1);
		person1.getAddresses().add(address2);

		person2.getAddresses().add(address1);

		em.persist(person1);
		em.persist(person2);
		
		em.flush();
		
		
		
	}

}
