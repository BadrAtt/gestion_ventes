package com.mql.gestionventes.Factory;
import com.mql.gestionventes.Services.*;

public class ServiceFactory {

	private static ArticleService articleService;
	private static CommandeService commandeService;
	private static ClientService clientService;
	private static UtilisateurService userService;
	private static InventaireService inventaireService;
	private static AchatService achatService;
	
	
	/**
	 * un Bloc static pour initialiser les membres statiques de la classe
	 */
	static {
		articleService = new ArticleService();
		commandeService = new CommandeService();
		clientService = new ClientService();
		userService = new UtilisateurService();
		inventaireService = new InventaireService();
		achatService = new AchatService();
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

	public static InventaireService getInventaireService() {
		return inventaireService;
	}

	public static AchatService getAchatService() {
		return achatService;
	}
	
	
}
