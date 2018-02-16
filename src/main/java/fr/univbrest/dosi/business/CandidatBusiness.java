package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;

public interface CandidatBusiness {

	Candidat creerCandidat (Candidat NewCandidat);
	void supprimerCandidat (Candidat OldCandidat);
	List<Candidat> RetrouverToutLesCandidats();
	void supprimerCandidat(String id);
	Candidat RetrouverCandidatParId(String id);
	List<Candidat> RetrouverCandidatParNom(String nom);
	List<Candidat> retrouverCandidatParUniv(String univ);
}
