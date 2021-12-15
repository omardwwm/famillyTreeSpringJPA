package com.familytree.gs.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.familytree.gs.dao.PersonneDao;
import com.familytree.gs.model.Personne;
import com.familytree.gs.service.PersonneService;

@Service("personneService")
@Transactional
public class PersonneServiceImpl implements PersonneService {

	@Autowired
	private PersonneDao personneDao;

	public List<Personne> findAll() {
		List<Personne>  personnes = new ArrayList<>();
		personneDao.findAll().forEach(personnes::add);
		return personnes;
	}

	public Personne findById(long id) {
		return personneDao.findById(id).get();	
	}

	public Personne save(Personne personne) {
		return personneDao.save(personne);
	}

	public Personne duplicateById(long id) {
		Personne p = this.findById(id);
		
		Personne duplicat = new Personne();
		duplicat.setRedacteur(p.getRedacteur());
		duplicat.setNom(p.getNom());
		duplicat.setPrenom(p.getPrenom());
		duplicat.setDateNaissance(p.getDateNaissance());
		duplicat.setDateDeces(p.getDateDeces());
		duplicat.setSexe(p.getSexe());
		duplicat.setPaysNaissance(p.getPaysNaissance());

		return personneDao.save(duplicat);
	}

	public Personne update(Personne personne) {
		return personneDao.save(personne);
	}

	public void deleteById(long id) {
		personneDao.deleteById(id);
	}

	public boolean isExist(Personne personne) {
		return findById(personne.getId()) != null;
	}

	public void deleteAll() {
		
	}

	public PersonneDao getPersonneDao() {
		return personneDao;
	}

	public void setPersonneDao(PersonneDao personneDao) {
		this.personneDao = personneDao;
	}
}