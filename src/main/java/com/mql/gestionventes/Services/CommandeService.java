package com.mql.gestionventes.Services;

import java.util.List;

import com.mql.gestionventes.Entity.Commande;
import com.mql.gestionventes.Factory.DaoFactory;

public class CommandeService {

	public Commande getCommandeByCode(int code) {
		return DaoFactory.getCommandeDao().find(code);
	}
	
	public boolean createCommande(Commande commande) {
		return DaoFactory.getCommandeDao().create(commande);
	}
	
	public boolean updateCommande(Commande commande) {
		return DaoFactory.getCommandeDao().update(commande);
	}
	
	public boolean deleteCommande(Commande commande) {
		return DaoFactory.getCommandeDao().delete(commande);
	}
	
	public List<Commande> getAllCommandes() {
		return DaoFactory.getCommandeDao().getAll();
	}
}

