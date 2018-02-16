package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;

@Component
public class PromotionBusinessJPA implements PromotionBusiness {
	
	private PromotionRepository repos;
	private EnseignantRepository repos_ens;

	@Autowired
	public PromotionBusinessJPA (PromotionRepository repos,EnseignantRepository repos_ens) {
		this.repos=repos;
		this.repos_ens=repos_ens;
	}
	
	
	public PromotionBusinessJPA(PromotionRepository repos) {
		this.repos=repos;
	}
	
	@Override
	public Promotion creerPromotion(Promotion NewPromotion) {
		return repos.save(NewPromotion);
	}
	
	@Override
	public void supprimerPromotion(PromotionPK key) {			
		 repos.delete(RetrouverPromotionParId(key));
	}
	
	@Override
	public Promotion RetrouverPromotionParSigle(String sigle) {
		return repos.findBySiglePromotion(sigle);
	}
	
	@Override
	public List<Promotion> RetrouverPromotionParNumEnseignant(Long id_ens) {
		Enseignant ens = repos_ens.findBynoEnseignant(id_ens);
		return (List<Promotion>)repos.findByEnseignant(ens);
	}
	
	@Override
	public List<Promotion> RetrouverToutesLesPromotions() {
		return (List<Promotion>) repos.findAll();
	}
	
	@Override
	public Promotion RetrouverPromotionParId(PromotionPK id) {
		return repos.findById(id);
	}

	public List<Promotion> RetrouverParEnseignant(Enseignant ens1) {
		return repos.findByEnseignant(ens1);
	}
	
	@Override
	public Promotion UpdatePromotion(Promotion PromotionAMaj) {		
		return repos.save(PromotionAMaj);
	}

}
