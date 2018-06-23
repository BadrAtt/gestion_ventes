package com.mql.gestionventes.Actions;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Entity.Commande;
import com.mql.gestionventes.Factory.ServiceFactory;;

@ManagedBean (name = "ajoutCommande")
@RequestScoped
public class AjoutCommandeAction {

	private Client  commandeClient;
	private Article commadeArticle;
	private int  qteCommande;
	private String  commandNotes;
	private boolean addsuccess;
	
	private List<Client> listeClients = new ArrayList<Client>();
	private List<Article> listeArticles = new ArrayList<Article>();
	
	
	@PostConstruct
	public void init() {
		listeClients = ServiceFactory.getClientService().getAllClients();
		listeArticles = ServiceFactory.getArticleService().allArticles();
	}
	
	public Client getCommandeClient() {
		return commandeClient;
	}
	public void setCommandeClient(Client commandeClient) {
		this.commandeClient = commandeClient;
	}
	public Article getCommadeArticle() {
		return commadeArticle;
	}
	public void setCommadeArticle(Article commadeArticle) {
		this.commadeArticle = commadeArticle;
	}
	public int getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}
	public String getCommandNotes() {
		return commandNotes;
	}
	public void setCommandNotes(String commandNotes) {
		this.commandNotes = commandNotes;
	}
	
	public boolean isAddsuccess() {
		return addsuccess;
	}
	public void setAddsuccess(boolean addsuccess) {
		this.addsuccess = addsuccess;
	}
	
	
	public List<Client> getListeClients() {
		return listeClients;
	}
	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
	public List<Article> getListeArticles() {
		return listeArticles;
	}
	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	public void addCommande() {
		
		Commande commande = new Commande();
		commande.setClient(commandeClient);
		commande.setArticleCmd(commadeArticle);
		commande.setNotes(commandNotes);
		commande.setDateCommande(new Date());
		
		if(ServiceFactory.getCommandeService().createCommande(commande)) {
			setAddsuccess(true);
		}
		else {
			setAddsuccess(false);
		}
	}
}
