package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.UniteEnseignement;
import fr.univbrest.dosi.bean.UniteEnseignementPK;

public interface UniteEnseignementRepository extends CrudRepository<UniteEnseignement,UniteEnseignementPK> {

	List<UniteEnseignement> findByEnseignant(Enseignant ens1);

}
