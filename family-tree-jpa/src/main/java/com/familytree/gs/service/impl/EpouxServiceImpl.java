package com.familytree.gs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.familytree.gs.dao.EpouxDao;
import com.familytree.gs.model.Epoux;
import com.familytree.gs.service.EpouxService;

@Service("epouxService")
@Transactional
public class EpouxServiceImpl implements EpouxService {

	@Autowired
	private EpouxDao epouxDao;
	
	@Override
	public Epoux findById(long id) {
		return epouxDao.findById(id).get();
	}

	@Override
	public Epoux save(Epoux object) {
		return epouxDao.save(object);
	}

	@Override
	public Epoux update(Epoux object) {
		return epouxDao.save(object);
	}

	@Override
	public void deleteById(long id) {
		epouxDao.deleteById(id);
	}

	@Override
	public List<Epoux> findAll() {
		return epouxDao.findAll();
	}

	@Override
	public void deleteAll() {
		epouxDao.deleteAll();
	}

	@Override
	public boolean isExist(Epoux user) {
		return user != null && findById(user.getId()) != null;
	}

	@Override
	public Epoux duplicateById(long id) { 
		final Epoux modele = findById(id);
		
		if (modele == null)
			return null;
		
		Epoux epoux = new Epoux();
		epoux.setRedacteur(modele.getRedacteur());
		epoux.setSujet(modele.getSujet());
		epoux.setConjoint(modele.getConjoint());
		epoux.setDateDebut(modele.getDateDebut());
		epoux.setDateFin(modele.getDateFin());
		
		return save(epoux);
	}

}
