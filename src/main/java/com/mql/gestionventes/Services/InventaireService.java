package com.mql.gestionventes.Services;

import java.util.Date;
import java.util.List;

import com.mql.gestionventes.Entity.Inventaire;
import com.mql.gestionventes.Factory.DaoFactory;

/**
 * La classe service represente  la couche metier de notre application,
 * chaque entité a sa propre classe metier qui permet de faire les differents traitements
 * liés à cette entité
 */

public class InventaireService {

	public Inventaire getInventaireByCode(int code) {
		return DaoFactory.getInventaireDao().find(code);
	}
	
	public boolean createInventaire(Inventaire inventaire) {
		return DaoFactory.getInventaireDao().create(inventaire);
	}
	
	/**
	 * 
	 * @param Inventaire: l'Inventaire a modifer avec des nouveaux informations
	 * @return true ou false
	 */
	
	public boolean updateInventaire(Inventaire inventaire) {
		return DaoFactory.getInventaireDao().update(inventaire);
	}
	
	public boolean deleteInventaire(Inventaire inventaire) {
		return DaoFactory.getInventaireDao().delete(inventaire);
	}
	
	public List<Inventaire> allInventaires(){
		return DaoFactory.getInventaireDao().getAll();
	}

	public Inventaire getLastInv(Date date, int artId) {
		return DaoFactory.getInventaireDao().lastInv(date, artId);
	}
}
