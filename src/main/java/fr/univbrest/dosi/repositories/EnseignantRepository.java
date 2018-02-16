package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant,Long>{

	

	Enseignant findBynoEnseignant(long noEnseignant);

	List<Enseignant> findByType(String type);

	Enseignant findByNom(String nom);



}
