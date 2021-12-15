package com.familytree.gs.model.trash;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Realisateur {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nom;
	
	@OneToMany(mappedBy = "director")
	private List<Film> filmographie;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public List<Film> getFilmographie() {
		return filmographie;
	}
	public void setFilmographie(List<Film> filmographie) {
		this.filmographie = filmographie;
	}

}
