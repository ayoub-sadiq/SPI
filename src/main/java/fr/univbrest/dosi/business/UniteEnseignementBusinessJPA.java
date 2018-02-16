package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;
import fr.univbrest.dosi.repositories.UniteEnseignementRepository;

@Component
public class UniteEnseignementBusinessJPA implements UniteEnseignementBusiness{

	private UniteEnseignementRepository repos;
	private EnseignantRepository repos_ens;

	@Autowired
	public UniteEnseignementBusinessJPA (UniteEnseignementRepository repos,EnseignantRepository repos_ens) {
		this.repos=repos;
		this.repos_ens=repos_ens;
	}
	
	
	public UniteEnseignementBusinessJPA(UniteEnseignementRepository repos) {
		this.repos=repos;
	}
	
	@Override
	public UniteEnseignement creerUniteEnseignement(UniteEnseignement NewUniteEnseignement) {
		return repos.save(NewUniteEnseignement);
	}
	
	@Override
	public void SupprimerUniteEnseignement(UniteEnseignementPK key) {
		repos.delete(RetrouverUEParId(key));
	}
	
	
	
	@Override
	public List<UniteEnseignement> RetrouverToutsLesUE() {
		return (List<UniteEnseignement>) repos.findAll();
	}
	
	@Override
	public UniteEnseignement RetrouverUEParId(UniteEnseignementPK id) {
		return repos.findOne(id);
	}
	
	@Override
	public UniteEnseignement UpdateUniteEnseignement(UniteEnseignement UniteEnseignementAMaj) {		
		return repos.save(UniteEnseignementAMaj);
	}
	

	
	@Override
	public List<UniteEnseignement> RetrouverUniteEnseignementParEnseignant(Long id_ens) {
		Enseignant ens = repos_ens.findBynoEnseignant(id_ens);
		return (List<UniteEnseignement>)repos.findByEnseignant(ens);
	}
	
}
