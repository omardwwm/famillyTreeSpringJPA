package com.familytree.gs.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Fetch;

import com.familytree.gs.model.enums.SexeEnum;

@Entity
public class Personne {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@Fetch(FetchMode.JOIN)
	@JoinColumn(name = "redacteur_id")
	private Utilisateur redacteur;
	
	private String nom;
	private String prenom;
	private Date dateNaissance;
	private Date dateDeces;
	private SexeEnum sexe;
	private String paysNaissance;
	
	public Personne() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Utilisateur getRedacteur() {
		return redacteur;
	}

	public void setRedacteur(Utilisateur redacteur) {
		this.redacteur = redacteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public SexeEnum getSexe() {
		return sexe;
	}

	public void setSexe(SexeEnum sexe) {
		this.sexe = sexe;
	}

	public String getPaysNaissance() {
		return paysNaissance;
	}

	public void setPaysNaissance(String paysNaissance) {
		this.paysNaissance = paysNaissance;
	}

	@Override
	public String toString() {
		return "Personne [id=" + id + ", redacteur=" + redacteur + ", nom=" + nom + ", prenom=" + prenom
				+ ", dateNaissance=" + dateNaissance + ", sexe=" + sexe + ", paysNaissance=" + paysNaissance + "]";
	}
	
}
