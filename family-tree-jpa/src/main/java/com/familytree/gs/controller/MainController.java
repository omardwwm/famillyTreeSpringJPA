package com.familytree.gs.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.familytree.gs.model.Epoux;
import com.familytree.gs.model.Personne;
import com.familytree.gs.model.enums.SexeEnum;
import com.familytree.gs.service.EpouxService;
import com.familytree.gs.service.PersonneService;

@Controller
//@RequestMapping(path = "${main}/main")
public class MainController {

	@Autowired
	private PersonneService personneService;
	
	@Autowired
	private EpouxService epouxService;
	
	private List<String> annees;
	Map<Integer, String> moisMap;
	
	public MainController() {
		
		annees = new ArrayList<>();
		for (int i = 1890; i <= 2021; i++) {
			annees.add(i + "");
		}
		
		moisMap = new HashMap<>();
		moisMap.put(1, "janvier");
		moisMap.put(2, "février");
		moisMap.put(3, "mars");
		moisMap.put(4, "avril");
		moisMap.put(5, "mai");
		moisMap.put(6, "juin");
		moisMap.put(7, "juillet");
		moisMap.put(8, "aout");
		moisMap.put(9, "septembre");
		moisMap.put(10, "octobre");
		moisMap.put(11, "novembre");
		moisMap.put(12, "décembre");
	}
	
	@RequestMapping(
			value = "/login", 
			method = RequestMethod.GET
		)
		public String afficherLoginPage() {
			return "login.jsp";
	}
	
	
	

	@RequestMapping(
		value = "/admin-personnes-add", 
		method = RequestMethod.GET
	)
	public String addPersonne(Model m) {
		
		m.addAttribute("annees", annees);
		m.addAttribute("moisMap", moisMap);
		
		return "addPersonne.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(
		value = "/admin-personnes-add", 
		method = RequestMethod.POST
	)
	public String savePersonne(
		Model m,
		@RequestParam String id,
		@RequestParam String prenom,
		@RequestParam String nom,
		@RequestParam String date_naissance_annee,
		@RequestParam String date_naissance_mois,
		@RequestParam String date_naissance_jour,
		@RequestParam String pays_naissance,
		@RequestParam String sexe
		) {
		
		Personne personne = new Personne();
		if (!id.isBlank()) {
			personne.setId(new Long(id));
		}
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setPaysNaissance(pays_naissance);
		personne.setSexe("M".equals(sexe) ? SexeEnum.M : SexeEnum.F);
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(date_naissance_annee + '-' + date_naissance_mois + '-' + date_naissance_jour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (date != null) {
			personne.setDateNaissance(date);
		}
		
		personneService.save(personne);
		
		return afficherListePersonne(m);
	}
	
	@RequestMapping(
		value = "/liste-personnes", 
		method = RequestMethod.GET
	)
	public String afficherListePersonne(Model m) {
		
		List<Personne> personnes = personneService.findAll();
		m.addAttribute("personnes", personnes);
		m.addAttribute("formatter", (new SimpleDateFormat("dd/MM/yyyy")));
		
		return "listePersonnes.jsp";
	}
	
	@RequestMapping(
		value = "/liste-personnes-actions", 
		method = RequestMethod.POST
	)
	public String actionsListePersonne(Model m, @RequestParam String id, @RequestParam String type_action) {
		
		List<Personne> personnes = null;
		
		switch(type_action) {
		case "MODIFICATION":
			final Personne p = personneService.findById(Long.parseLong(id));
			m.addAttribute("personne", p);
			// Récupérez l'annee de naissance,
			// le mois de naissance
			// et le jour de naissance
			// Pour les passer à la vue.
			m.addAttribute("annees", annees);
			m.addAttribute("moisMap", moisMap);
			return "editPersonne.jsp";
			
		case "DUPLICATION":
			personneService.duplicateById(Long.parseLong(id));
			personnes = personneService.findAll();
			m.addAttribute("message", "Votre requête a bien été exécutée.");
			m.addAttribute("personnes", personnes);
			return "listePersonnes.jsp";
			
		case "SUPPRESSION":
			personneService.deleteById(Long.parseLong(id));
			personnes = personneService.findAll();
			m.addAttribute("message", "Votre requête a bien été exécutée.");
			m.addAttribute("personnes", personnes);
			return "listePersonnes.jsp";
		}
		
		return null;
	}
	
	@RequestMapping(
		value = "/admin-epoux-add", 
		method = RequestMethod.GET
	)
	public String addEpoux(Model m) {

		List<Personne> personnes = personneService.findAll();
		m.addAttribute("annees", annees);
		m.addAttribute("moisMap", moisMap);
		m.addAttribute("personnes", personnes);
		
		return "addEpoux.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(
		value = "/admin-epoux-add", 
		method = RequestMethod.POST
	)
	public String saveEpoux(
		Model m,
		@RequestParam String id,
		@RequestParam long sujet_id,
		@RequestParam long conjoint_id,
		@RequestParam String date_debut_annee,
		@RequestParam String date_debut_mois,
		@RequestParam String date_debut_jour,
		@RequestParam String date_fin_annee,
		@RequestParam String date_fin_mois,
		@RequestParam String date_fin_jour
		) {
		
		Epoux epoux = new Epoux();
		if (!id.isBlank()) {
			epoux.setId(new Long(id));
		}
		
		final Personne sujet = personneService.findById(sujet_id);
		final Personne conjoint = personneService.findById(conjoint_id);
		epoux.setSujet(sujet);
		epoux.setConjoint(conjoint);
		
		Date dateDebut = null, dateFin = null;
		try {
			dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(date_debut_annee + '-' + date_debut_mois + '-' + date_debut_jour);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if (dateDebut != null) {
			epoux.setDateDebut(dateDebut);
		}
		
		if (!date_fin_annee.isBlank() && !date_fin_mois.isBlank() && !date_fin_jour.isBlank()) {
			try {
				dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(date_fin_annee + '-' + date_fin_mois + '-' + date_fin_jour);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			if (dateFin != null) {
				epoux.setDateFin(dateFin);
			}
		}
		
		epouxService.save(epoux);
		
		return afficherListeEpoux(m);
	}

	@RequestMapping(
		value = "/liste-epoux", 
		method = RequestMethod.GET
	)
	public String afficherListeEpoux(Model m) {
		
		List<Epoux> epoux = epouxService.findAll();
		m.addAttribute("listeEpoux", epoux);
		m.addAttribute("formatter", (new SimpleDateFormat("dd/MM/yyyy")));
		
		return "listeEpoux.jsp";
	}
	
	@SuppressWarnings("deprecation")
	@RequestMapping(
		value = "/liste-epoux-actions", 
		method = RequestMethod.POST
	)
	public String actionsListeEpoux(
			Model m, 
			@RequestParam String id,
			@RequestParam String type_action
	) {
		
		List<Epoux> listeEpoux = null;
		
		switch(type_action) {
		case "MODIFICATION":
			final Epoux p = epouxService.findById(new Long(id));
			m.addAttribute("epoux", p);
			m.addAttribute("annees", annees);
			m.addAttribute("moisMap", moisMap);
			m.addAttribute("formatterAnnee", (new SimpleDateFormat("yyyy")));
			m.addAttribute("formatterMois", (new SimpleDateFormat("M")));
			m.addAttribute("formatterJour", (new SimpleDateFormat("d")));
			m.addAttribute("personnes", personneService.findAll());
			return "editEpoux.jsp";
			
		case "DUPLICATION":
			epouxService.duplicateById(new Long(id));
			listeEpoux = epouxService.findAll();
			m.addAttribute("message", "Votre requête a bien été exécutée.");
			m.addAttribute("listeEpoux", listeEpoux);
			return "listeEpoux.jsp";
			
		case "SUPPRESSION":
			epouxService.deleteById(new Long(id));
			listeEpoux = epouxService.findAll();
			m.addAttribute("message", "Votre requête a bien été exécutée.");
			m.addAttribute("listeEpoux", listeEpoux);
			return "listeEpoux.jsp";
		}
		
		return null;
	}
}
