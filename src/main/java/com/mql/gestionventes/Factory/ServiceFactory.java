package com.mql.gestionventes.Factory;
import com.mql.gestionventes.Services.*;

public class ServiceFactory {

	private static ArticleService articleService;
	private static CommandeService commandeService;
	private static ClientService clientService;
	private static UtilisateurService userService;
	
	
	/**
	 * un Bloc static pour initialiser les membres statiques de la classe
	 */
	static {
		articleService = new ArticleService();
		commandeService = new CommandeService();
		clientService = new ClientService();
		userService = new UtilisateurService();
	}

	public static ArticleService getArticleService() {
		return articleService;
	}

	public static CommandeService getCommandeService() {
		return commandeService;
	}

	public static ClientService getClientService() {
		return clientService;
	}

	public static UtilisateurService getUserService() {
		return userService;
	}
	
}
