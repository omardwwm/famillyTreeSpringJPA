package com.familytree.gs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.familytree.gs.model.enums.StatusLienEnum;
import com.familytree.gs.model.enums.TypeRelationEnum;

@Entity
public class Lien {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "redacteur_id")
	private Utilisateur redacteur;
	
	@ManyToOne
	@JoinColumn(name = "sujet_id")
	private Personne sujet;
	
	@ManyToOne
	@JoinColumn(name = "relatif_id")
	private Personne relatif;
	
	private TypeRelationEnum typeRelation;
	private StatusLienEnum status;
	
	public Lien() {}
	
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
	
	public Personne getSujet() {
		return sujet;
	}
	
	public void setSujet(Personne sujet) {
		this.sujet = sujet;
	}
	
	public Personne getRelatif() {
		return relatif;
	}
	
	public void setRelatif(Personne relatif) {
		this.relatif = relatif;
	}
	
	public TypeRelationEnum getTypeRelation() {
		return typeRelation;
	}
	
	public void setTypeRelation(TypeRelationEnum typeRelation) {
		this.typeRelation = typeRelation;
	}
	
	public StatusLienEnum getStatus() {
		return status;
	}
	
	public void setStatus(StatusLienEnum status) {
		this.status = status;
	}
	
	
	
}
