package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignants")
public class EnseignantController {

	private EnseignantBusiness business;

	@Autowired
	public EnseignantController (EnseignantBusiness business) {
		this.business = business;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.POST)
	public Enseignant AjouterEnseignant(@RequestBody Enseignant enseignant) {
		return business.creerEnseignant(enseignant);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/UpdateById/{id}")
	public Enseignant UpdateEnseignant(@RequestBody Enseignant enseignant) {
		return business.UpdateEnseignant(enseignant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/remove/{id}")
	public void SupprimerEnseignant(@RequestBody Long id) {
		 business.supprimerEnseignant(id);
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant>  RetrouverTousLesEnseignants(){
		return business.RetrouverToutLesEnseignant();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchById/{id}")
	public Enseignant RecupererEnseignantParId(@PathVariable Long id) {
		return business.RetrouverEnseignantParId(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByType/{type}")
	public List<Enseignant> RecupererEnseignantParType(@PathVariable String type) {
		return business.RetrouverEnseignantParType(type);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByNomEtPrenom/{nom}/{prenom}")
	public Enseignant RecupererEnseignantParNomEtPrenom(@PathVariable String nom,@PathVariable String prenom) {
		return business.RetrouverEnseignantParNomEtPrenom(nom, prenom);
	}
	
	
}
