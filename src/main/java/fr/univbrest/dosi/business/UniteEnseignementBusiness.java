package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;

public interface UniteEnseignementBusiness {

	List<UniteEnseignement> RetrouverToutsLesUE();

	UniteEnseignement RetrouverUEParId(UniteEnseignementPK id);

	UniteEnseignement creerUniteEnseignement(UniteEnseignement NewUniteEnseignement);

	void SupprimerUniteEnseignement(UniteEnseignementPK key);

	UniteEnseignement UpdateUniteEnseignement(UniteEnseignement UniteEnseignementAMaj);



	List<UniteEnseignement> RetrouverUniteEnseignementParEnseignant(Long id_ens);

}
