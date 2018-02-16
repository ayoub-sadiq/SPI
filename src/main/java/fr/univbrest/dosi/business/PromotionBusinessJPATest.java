package fr.univbrest.dosi.business;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;
import fr.univbrest.dosi.business.EnseignantBusinessJPATest.EnseignantRepositoryJPAList;
import fr.univbrest.dosi.repositories.EnseignantRepository;
import fr.univbrest.dosi.repositories.PromotionRepository;

public class PromotionBusinessJPATest {

	PromotionBusinessJPA business;
	EnseignantBusinessJPA business_ens;
	
	
	@Test
	public void DoitCreerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);
		
		Enseignant ens2 = new Enseignant(002,"nom2","prenom2","type2");
		PromotionPK key2 = new PromotionPK("year2","formation2");
		Promotion promo2 = new Promotion(key2,"sigle2",ens2);
		
		business.creerPromotion(promo1);
		business.creerPromotion(promo2);
		assertThat(repos.count()).isEqualTo(2);			
	}
	
	@Test
	public void DoitSupprimerUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);

		
		business.creerPromotion(promo1);
		assertThat(repos.count()).isEqualTo(1);		
		
		business.supprimerPromotion(promo1.getId());
		assertThat(repos.count()).isEqualTo(0);	
	}
	
	@Test
	public void DoitRecupererToutesLesPromotions() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);

		business.creerPromotion(promo1);
		List<Promotion> lis = business.RetrouverToutesLesPromotions();
		assertThat(lis.size()).isEqualTo(1);		
		
	
	}
	
	@Test
	public void DoitRecupererUnePromotionParSigle() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);

		business.creerPromotion(promo1);
		Promotion promo = business.RetrouverPromotionParSigle("sigle2");
		assertThat(promo.getSiglePromotion()).isEqualTo("sigle2");		
		
	
	}
	@Test
	public void DoitRecupererUnePromotionParEnseignant() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(1,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);

		business.creerPromotion(promo1);
		List<Promotion> lis = business.RetrouverParEnseignant(ens1);
		assertThat(lis.size()).isEqualTo(1);	
		
	
	}
	@Test
	public void DoitRecupererUnePromotion() {
		PromotionRepository repos = new PromotionRepositoryList();
		business = new PromotionBusinessJPA(repos);
		PromotionPK key1 = new PromotionPK("year1","formation1");
		Enseignant ens1 = new Enseignant(001,"nom1","prenom1","type1");
		Promotion promo1 = new Promotion(key1,"sigle2",ens1);

		business.creerPromotion(promo1);
		Promotion promo = business.RetrouverPromotionParId(key1);
		assertThat(promo).isEqualTo(promo1);		
		
	
	}
	
	public class PromotionRepositoryList implements PromotionRepository{

		private List<Promotion> data;
		public PromotionRepositoryList () {
			data = Lists.newArrayList();
		}
		
		@Override
		public <S extends Promotion> S save(S entity) {
			data.add(entity);
			return entity;
			
		}

		@Override
		public <S extends Promotion> Iterable<S> save(Iterable<S> entities) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Promotion findOne(PromotionPK id) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean exists(PromotionPK id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public Iterable<Promotion> findAll() {
			// TODO Auto-generated method stub
			return data;
		}

		@Override
		public Iterable<Promotion> findAll(Iterable<PromotionPK> ids) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long count() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public void delete(PromotionPK id) {
			data.remove(business.RetrouverPromotionParId(id));
			
		}

		@Override
		public void delete(Promotion entity) {
			data.remove(entity);
			
		}

		@Override
		public void delete(Iterable<? extends Promotion> entities) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void deleteAll() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Promotion findById(PromotionPK id) {
			Promotion e = new Promotion();
			for(Promotion c : data) {
				
				if (c.getId()==id) {
					e=c;					
				}					}			
			return e;
		}

		@Override
		public Promotion findBySiglePromotion(String sigle) {
			Promotion e = new Promotion();
			for(Promotion c : data) {
				
				if (c.getSiglePromotion()==sigle) {
					e=c;					
				}					}			
			return e;
		
		}

		@Override
		public List<Promotion> findByEnseignant(Enseignant ens) {
			List<Promotion> lis = new ArrayList<>();
			for(Promotion c : data) {
				
				if (c.getEnseignant()==ens) {
					lis.add(c);				
				}					}			
			return lis;
		}
		
	}
}
