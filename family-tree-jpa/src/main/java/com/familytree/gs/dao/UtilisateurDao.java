package com.familytree.gs.dao;

import org.springframework.data.repository.CrudRepository;

import com.familytree.gs.model.Utilisateur;

public interface UtilisateurDao extends CrudRepository<Utilisateur, Long> {

}
