package com.mql.gestionventes.Services;

import java.util.Date;
import java.util.List;

import com.mql.gestionventes.Entity.Achat;
import com.mql.gestionventes.Factory.DaoFactory;

/**
 * La classe service represente  la couche metier de notre application,
 * chaque entité a sa propre classe metier qui permet de faire les differents traitements
 * liés à cette entité
 */

public class AchatService {

	public Achat getAchatByCode(int code) {
		return DaoFactory.getAchatDao().find(code);
	}
	
	public boolean createAchat(Achat achat) {
		return DaoFactory.getAchatDao().create(achat);
	}
	
	/**
	 * 
	 * @param Achat: l'Achat a modifer avec des nouveaux informations
	 * @return true ou false
	 */
	
	public boolean updateAchat(Achat achat) {
		return DaoFactory.getAchatDao().update(achat);
	}
	
	public boolean deleteAchat(Achat achat) {
		return DaoFactory.getAchatDao().delete(achat);
	}
	
	public List<Achat> allAchats(){
		return DaoFactory.getAchatDao().getAll();
	}

	public long getQuantiteAchete(Date startDate, Date endDate, int idArt) {
		return DaoFactory.getAchatDao().getQuantiteAchete(startDate, endDate, idArt);
	}
}
