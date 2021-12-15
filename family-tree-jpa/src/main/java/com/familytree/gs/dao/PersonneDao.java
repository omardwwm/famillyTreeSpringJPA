package com.familytree.gs.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.familytree.gs.model.Personne;

public interface PersonneDao extends JpaRepository<Personne, Long> {

}
