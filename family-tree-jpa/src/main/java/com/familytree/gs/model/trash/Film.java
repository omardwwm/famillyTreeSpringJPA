package com.familytree.gs.model.trash;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Film {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String titre;
	private int dureeEnSecondes;
	
	@ManyToOne
	private Realisateur director;
	
	@ManyToMany
	@JoinTable(
		name = "acteur_film", 
		joinColumns = @JoinColumn(name = "film_id"),
		inverseJoinColumns = @JoinColumn(name = "acteur_id")
	)
	private List<Acteur> casting;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getDureeEnSecondes() {
		return dureeEnSecondes;
	}
	public void setDureeEnSecondes(int dureeEnSecondes) {
		this.dureeEnSecondes = dureeEnSecondes;
	}
	public Realisateur getDirector() {
		return director;
	}
	public void setDirector(Realisateur director) {
		this.director = director;
	}
	public List<Acteur> getCasting() {
		return casting;
	}
	public void setCasting(List<Acteur> casting) {
		this.casting = casting;
	}
	
}
