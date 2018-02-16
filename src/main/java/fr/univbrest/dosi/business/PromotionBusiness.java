package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Promotion;
import fr.univbrest.dosi.bean.PromotionPK;

public interface PromotionBusiness {

	List<Promotion> RetrouverToutesLesPromotions();

	Promotion RetrouverPromotionParId(PromotionPK id);

	Promotion creerPromotion(Promotion NewPromotion);

	void supprimerPromotion(PromotionPK key);

	Promotion RetrouverPromotionParSigle(String sigle);

	List<Promotion> RetrouverPromotionParNumEnseignant(Long id_ens);

	Promotion UpdatePromotion(Promotion promotionAMaj);

}
