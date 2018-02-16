package fr.univbrest.dosi.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.business.PromotionBusiness;

@RestController
@RequestMapping("/promotions")
public class PromotionController {

	private PromotionBusiness business;

	@Autowired
	public PromotionController (PromotionBusiness business) {
		this.business = business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Promotion AjouterEnseignant(@RequestBody Promotion NewPromotion) {
		return business.creerPromotion(NewPromotion);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/remove/{formation}/{year}")
	public void SupprimerPromotion(@PathVariable String formation,@PathVariable String year) {
		PromotionPK key = new PromotionPK();
		key.setAnneeUniversitaire(year);
		key.setCodeFormation(formation);
		 business.supprimerPromotion(key);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Promotion>  RetrouverToutesLesPromotions(){
		return business.RetrouverToutesLesPromotions();
	}
	
	/*@RequestMapping(method = RequestMethod.GET, value="/searchById")
	public Promotion RecupererPromotionParId(@RequestBody PromotionPK id) {
		return business.RetrouverPromotionParId(id);
	}*/
	
	@RequestMapping(method = RequestMethod.GET, value="/searchBySigle/{sigle}")
	public Promotion RecupererPromotionParSigle(@PathVariable String sigle) {
		return business.RetrouverPromotionParSigle(sigle);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByEnseignant/{id}")
	public List<Promotion> RecupererPromotionParEnseignant(@PathVariable Long id) {
		return business.RetrouverPromotionParNumEnseignant(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchById/{formation}/{year}")
	public Promotion RecupererPromotionParId(@PathVariable String formation,@PathVariable String year) {
		PromotionPK key = new PromotionPK();
		key.setAnneeUniversitaire(year);
		key.setCodeFormation(formation);
		return business.RetrouverPromotionParId(key);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update}")
	public Promotion UpdateFormation(@RequestBody Promotion PromotionAMaj) {
		return business.UpdatePromotion(PromotionAMaj);
	}
	
	
	
}
