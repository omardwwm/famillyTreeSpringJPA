package com.familytree.gs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Temoignage {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@NotNull
	@JoinColumn(name = "sujet_id")
	private Personne sujet;
	
	@ManyToOne
	@JoinColumn(name = "redacteur_id")
	private Utilisateur redacteur;
	
	private Date date;
	private String texte;
	private int nbLikes;
	private int nbAttestations;
	private boolean prive;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public Personne getSujet() {
		return sujet;
	}
	
	public void setSujet(Personne sujet) {
		this.sujet = sujet;
	}
	
	public Utilisateur getRedacteur() {
		return redacteur;
	}
	
	public void setRedacteur(Utilisateur redacteur) {
		this.redacteur = redacteur;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public void setTexte(String texte) {
		this.texte = texte;
	}
	
	public int getNbLikes() {
		return nbLikes;
	}
	
	public void setNbLikes(int nbLikes) {
		this.nbLikes = nbLikes;
	}
	
	public int getNbAttestations() {
		return nbAttestations;
	}
	
	public void setNbAttestations(int nbAttestations) {
		this.nbAttestations = nbAttestations;
	}
	
	public boolean isPrive() {
		return prive;
	}
	
	public void setPrive(boolean prive) {
		this.prive = prive;
	}
	
}
