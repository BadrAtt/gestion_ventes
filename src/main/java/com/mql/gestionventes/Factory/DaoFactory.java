package com.mql.gestionventes.Factory;

import com.mql.gestionventes.Dao.ArticleDao;
import com.mql.gestionventes.Dao.ClientDao;
import com.mql.gestionventes.Dao.CommandeDao;
import com.mql.gestionventes.Dao.UtilisateurDao;

public class DaoFactory {

	private static ArticleDao articleDao;
	private static CommandeDao commandeDao;
	private static ClientDao clientDao;
	private static UtilisateurDao utilisateurDao;
	
	
	/**
	 * un Bloc static pour initialiser les membres statiques de la classe
	 */
	static {
		articleDao = new ArticleDao();
		commandeDao = new CommandeDao();
		clientDao = new ClientDao();
		utilisateurDao = new UtilisateurDao();
	}
	
	public static ArticleDao getArticleDao() {
		return articleDao;
	}
	public static CommandeDao getCommandeDao() {
		return commandeDao;
	}
	public static ClientDao getClientDao() {
		return clientDao;
	}
	public static UtilisateurDao getUtilisateurDao() {
		return utilisateurDao;
	}		
	
}
