package fr.univbrest.dosi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.business.UniteEnseignementBusiness;

@RestController
@RequestMapping("/UE")
public class UniteEnseignementController {

	private UniteEnseignementBusiness business;

	@Autowired
	public UniteEnseignementController(UniteEnseignementBusiness business) {
		this.business=business;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public UniteEnseignement AjouterUniteEnseignement(@RequestBody UniteEnseignement NewUniteEnseignement) {
		return business.creerUniteEnseignement(NewUniteEnseignement);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/remove/{codeFormation}/{codeUE}")
	public void SupprimerUniteEnseignement(@PathVariable String codeFormation,@PathVariable String codeUE) {
		UniteEnseignementPK key = new UniteEnseignementPK();
		key.setCodeFormation(codeFormation);
		key.setCodeUe(codeUE);
		 business.SupprimerUniteEnseignement(key);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<UniteEnseignement>  RetrouverToutsLesUE(){
		return business.RetrouverToutsLesUE();
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchById/{formation}/{ue}")
	public UniteEnseignement RecupererPromotionParId(@PathVariable String formation,@PathVariable String ue ) {
		UniteEnseignementPK id = new UniteEnseignementPK();
		id.setCodeUe(ue);
		id.setCodeFormation(formation);
		return business.RetrouverUEParId(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/searchByEnseignant/{id}")
	public List<UniteEnseignement> RecupererUniteEnseignementParEnseignant(@PathVariable Long id) {
		return business.RetrouverUniteEnseignementParEnseignant(id);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/update}")
	public UniteEnseignement UpdateFormation(@RequestBody UniteEnseignement UniteEnseignementAMaj) {
		return business.UpdateUniteEnseignement(UniteEnseignementAMaj);
	}
	
}
