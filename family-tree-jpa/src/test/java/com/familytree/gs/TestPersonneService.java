package com.familytree.gs;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.familytree.gs.model.Personne;
import com.familytree.gs.service.PersonneService;

@RunWith(SpringRunner.class)
@DataJpaTest
class TestPersonneService {

	@Autowired
	private static PersonneService personneService;
	
	private static Personne henriIV;
	private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
		henriIV = new Personne();
		henriIV.setNom("BOURBON");
		henriIV.setPrenom("Henri");
		henriIV.setDateNaissance(formatter.parse("13/12/1553"));
		henriIV.setDateDeces(formatter.parse("14/05/1610"));
		henriIV.setPaysNaissance("FRANCE");
		
		henriIV = personneService.save(henriIV);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		personneService.deleteById(henriIV.getId());
	}

	@Test
	void testDuplication() {
		
		Personne henriIVbis = personneService.duplicateById(henriIV.getId());
		assertEquals(henriIV.getNom(), henriIVbis.getNom());
		assertEquals(henriIV.getPrenom(), henriIVbis.getPrenom());
		assertEquals(henriIV.getDateNaissance(), henriIVbis.getDateNaissance());
		assertEquals(henriIV.getDateDeces(), henriIVbis.getDateDeces());
		assertEquals(henriIV.getPaysNaissance(), henriIVbis.getPaysNaissance());
		assertNotEquals(henriIV.getId(), henriIVbis.getId());
		
	}

	public static PersonneService getPersonneService() {
		return personneService;
	}

	public static void setPersonneService(PersonneService personneService) {
		TestPersonneService.personneService = personneService;
	}

}
