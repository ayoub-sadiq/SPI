package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

public class EnseignantBusinessJPATest {

	EnseignantBusinessJPA business;
	
	@Test
	public void DoitCreerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Enseignant ens2 = new Enseignant(002,"nom2","prenom2","type2");
		
		business.creerEnseignant(ens2);
		business.creerEnseignant(ens1);
		assertThat(repos.count()).isEqualTo(2);	
		
	}
	
	@Test
	public void DoitSupprimerUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		business.creerEnseignant(ens1);
		assertThat(repos.count()).isEqualTo(1);	
		business.supprimerEnseignant(ens1);
		assertThat(repos.count()).isEqualTo(0);	
	}
	
	@Test
	public void DoitTrouverUnEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		business.creerEnseignant(ens1);
		Enseignant res = business.RetrouverEnseignantParId(001);
		assertThat(res.getNom().equals("nom1"));
	}
	
	@Test
	public void DoitTrouverTousLesEnseignant() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Enseignant ens2 = new Enseignant(002,"nom1","prenom1","type1");
		business.creerEnseignant(ens1);business.creerEnseignant(ens2);
		List<Enseignant> res = business.RetrouverToutLesEnseignant();
		assertThat(res.size()==2);
	}
	
	@Test
	public void DoitTrouverEnseignantParType() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Enseignant ens2 = new Enseignant(002,"nom1","prenom1","type2");
		business.creerEnseignant(ens1);business.creerEnseignant(ens2);
		List<Enseignant> res = business.RetrouverEnseignantParType("type1");
		assertThat(res.size()==1);
	}
	
	@Test
	public void DoitTrouverEnseignantParNomEtPrenom() {
		EnseignantRepository repos = new EnseignantRepositoryJPAList();
		business = new EnseignantBusinessJPA(repos);
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Enseignant ens2 = new Enseignant(002,"nom2","prenom2","type2");
		business.creerEnseignant(ens1);business.creerEnseignant(ens2);
		Enseignant res = business.RetrouverEnseignantParNomEtPrenom("nom1", "prenom1");
		assertThat(res.getNom().equals("nom1"));
	}
	
	
	class EnseignantRepositoryJPAList implements EnseignantRepository{

		private List<Enseignant> data;
		public EnseignantRepositoryJPAList () {
			data = Lists.newArrayList();
		}
		
		@Override
		public <S extends Enseignant> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Enseignant> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Enseignant findOne(Long id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(Long id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Enseignant> findAll() {
			// TODO Auto-generated method stub
			return data;
		}

		@Override
		public Iterable<Enseignant> findAll(Iterable<Long> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(Long id) {
			data.remove(business.RetrouverEnseignantParId(id));
		}

		@Override
		public void delete(Enseignant entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Enseignant> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Enseignant findBynoEnseignant(long noEnseignant) {

			Enseignant e = new Enseignant();
			for(Enseignant c : data) {
				
				if (c.getNoEnseignant()==noEnseignant) {
					e=c;					
				}					}			
			return e;
			
		}

		
	
		
		@Override
		public List<Enseignant> findByType(String type) {
			List<Enseignant> lis = new ArrayList<>();
						for(Enseignant c : data) {
				
				if (c.getType()==type) {
					lis.add(c);					
				}	
						}
				return lis;
		}

		@Override
		public Enseignant findByNom(String nom) {
			Enseignant e = new Enseignant();
			for(Enseignant c : data) {
				
				if (c.getNom()==nom) {
					e=c;					
				}					}			
			return e;
		}

		
		
	}
}
