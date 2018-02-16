package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.business.CandidatBusiness;

@RestController
@RequestMapping("/candidats")
public class CandidatController {

	private CandidatBusiness business;

	@Autowired
	public CandidatController(CandidatBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Candidat> retrouverTousLesCandidats(){
		return business.RetrouverToutLesCandidats();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Candidat AjouterCandidat(@RequestBody Candidat candidat) {
		return business.creerCandidat(candidat);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/remove/{id}")
	public void SupprimerCandidat(@RequestBody String id) {
		 business.supprimerCandidat(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchById/{id}")
	public Candidat RecupererCandidatParId(@PathVariable String id) {
		return business.RetrouverCandidatParId(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByNom/{nom}")
	public List<Candidat> RecupererCandidatParNom(@PathVariable String nom) {
		return business.RetrouverCandidatParNom(nom);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByUniv/{univ}")
	public List<Candidat> RecupererCandidatParUniv(@PathVariable String univ) {
		return business.retrouverCandidatParUniv(univ);
	}
	
}
