package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Component
public class EnseignantBusinessJPA implements EnseignantBusiness{

	private EnseignantRepository repos;

	
	@Autowired
	public  EnseignantBusinessJPA(EnseignantRepository repos) {
		this.repos = repos;
	}
	
	@Override
	public Enseignant creerEnseignant(Enseignant NewEnseignant) {
		return repos.save(NewEnseignant);
	}
	
	@Override
	public void supprimerEnseignant(long noEnseignant) {			
		 repos.delete(RetrouverEnseignantParId(noEnseignant));
	}
	
	@Override
	public void supprimerEnseignant(Enseignant ens) {			
		 repos.delete(ens);
	}
	
	@Override
	public List<Enseignant> RetrouverToutLesEnseignant() {
		return (List<Enseignant>) repos.findAll();
	}
	
	@Override
	public Enseignant RetrouverEnseignantParId(long noEnseignant) {
		return repos.findBynoEnseignant(noEnseignant);
	}
	
	@Override
	public List<Enseignant> RetrouverEnseignantParType(String type) {
		return (List<Enseignant>)repos.findByType(type);
	}
	
	@Override
	public Enseignant RetrouverEnseignantParNomEtPrenom(String nom,String prenom) {
		Enseignant NewEnseignant = repos.findByNom(nom);
		if(NewEnseignant.getPrenom().equals(prenom)) {
			return NewEnseignant;
		}
		else return null;
	}
	
	@Override
	public Enseignant UpdateEnseignant(Enseignant NewEnseignant) {
		return repos.save(NewEnseignant);		
	}
}
