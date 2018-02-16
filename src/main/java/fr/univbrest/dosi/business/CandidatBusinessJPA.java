package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.repositories.CandidatRepository;

@Component
public class CandidatBusinessJPA implements CandidatBusiness{

	
	private CandidatRepository repos;
	
	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		
		this.repos = repos;
	}

	
	@Override
	public Candidat creerCandidat(Candidat NewCandidat) {
		return repos.save(NewCandidat);
	}

	
	@Override
	public void supprimerCandidat(String id) {			
		 repos.delete(repos.findOne(id));
	}


	@Override
	public List<Candidat> RetrouverToutLesCandidats() {
		return (List<Candidat>) repos.findAll();
	}


	@Override
	public void supprimerCandidat(Candidat OldCandidat) {
		// TODO Auto-generated method stub	
	}


	@Override
	public Candidat RetrouverCandidatParId(String id) {
		return repos.findOne(id);
	}


	@Override
	public List<Candidat> RetrouverCandidatParNom(String nom) {
		return repos.findByNom(nom);
	}


	@Override
	public List<Candidat> retrouverCandidatParUniv(String univ) {
		return repos.findByUniversiteOrigine(univ);
	}

}
