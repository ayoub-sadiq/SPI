package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;


import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;

public class CandidatBusinessJPATest {

	CandidatBusinessJPA business;
	
	
	@Test
	public void doitCreerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1","nom1","prénom1","marrakech");
		Candidat candidat2 = new Candidat("2","nom2","prénom2","marrakech");
		
		 business.creerCandidat(candidat1);
		 business.creerCandidat(candidat2);
		
		//assertThat(resultat.getDebutAccreditation()).isCloseTo(new Date(), 500);
		assertThat(repos.count()).isEqualTo(2);
	}
	
	@Test 
	public void doitSupprimerUnCandidat() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		Candidat candidat1 = new Candidat("1","nom1","prénom1","marrakech");
		business.creerCandidat(candidat1);
		business.supprimerCandidat(candidat1);
		assertThat(repos.count()).isEqualTo(0);
	}
	
	@Test
	public void chercheByNom() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		
		Candidat candidat1 = new Candidat("1","nom1","prénom1","marrakech");
		Candidat candidat2 = new Candidat("2","nom2","prénom2","marrakech");
		
		 business.creerCandidat(candidat1);
		 business.creerCandidat(candidat2);
		 
		List<Candidat> lis=repos.findByNom("nom1");
		
		//assertThat(repos.count()).isEqualTo(2);
		
		for(Candidat c : lis) {
		assertThat(c.getNom()).isEqualTo("nom1");		
	}}
	
	
	
	@Test
	public void chercheByUniversiteOrigine() {
		CandidatRepository repos = new CandidatRepositoryList();
		business = new CandidatBusinessJPA(repos);
		
		Candidat candidat1 = new Candidat("1","nom1","prénom1","marrakech");
		Candidat candidat2 = new Candidat("2","nom2","prénom2","marrakech");
		
		 business.creerCandidat(candidat1);
		 business.creerCandidat(candidat2);
		 
		List<Candidat> lis=repos.findByUniversiteOrigine("marrakech");
		for(Candidat c : lis) {
			assertThat(c.getUniversiteOrigine()).isEqualTo("marrakech");		
		}}
	
	
	
	
	
	class CandidatRepositoryList implements CandidatRepository{
		private List<Candidat> data;
		public CandidatRepositoryList () {
			data = Lists.newArrayList();
		}
		
		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(String arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(Candidat c) {
			data.remove(c);
			
		}

		@Override
		public void delete(Iterable<? extends Candidat> arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public boolean exists(String arg0) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Candidat> findAll() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Iterable<Candidat> findAll(Iterable<String> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Candidat findOne(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public <S extends Candidat> S save(S entity) {
			data.add(entity);
			return entity;
		}

		@Override
		public <S extends Candidat> Iterable<S> save(Iterable<S> arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Candidat> findByNom(String nom) {
			List<Candidat> list = new ArrayList<>();
			
			for(Candidat c : data) {
				
				if (c.getNom()==nom) {
					list.add(c);
					
				}
			}		
			return list;
		}

		@Override
		public List<Candidat> findByUniversiteOrigine(String universiteOrigine) {
			List<Candidat> list = new ArrayList<>();
			
			for(Candidat c : data) {
				
				if (c.getUniversiteOrigine()==universiteOrigine) {
					list.add(c);
					
				}
			}		
			return list;
		}}
}

