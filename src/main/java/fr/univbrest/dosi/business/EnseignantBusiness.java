package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {

	Enseignant creerEnseignant(Enseignant NewEnseignant);

	
	List<Enseignant> RetrouverToutLesEnseignant();

	

	Enseignant UpdateEnseignant(Enseignant NewEnseignant);

	Enseignant RetrouverEnseignantParId(long noEnseignant);

	void supprimerEnseignant(long noEnseignant);


	List<Enseignant> RetrouverEnseignantParType(String type);


	Enseignant RetrouverEnseignantParNomEtPrenom(String nom, String prenom);


	void supprimerEnseignant(Enseignant ens);

}
