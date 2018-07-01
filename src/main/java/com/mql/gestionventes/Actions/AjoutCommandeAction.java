package com.mql.gestionventes.Actions;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Entity.Commande;
import com.mql.gestionventes.Factory.ServiceFactory;;

@ManagedBean (name = "ajoutCommande")
@ViewScoped
public class AjoutCommandeAction{

	private Client  commandeClient;
	private Article commandeArticle;
	private String  qteCommande;
	private String commandNotes;
	private boolean addsuccess;
	private boolean errorQte;
	private Commande commande;
	private String montantTotal;
	private Date dateCmd; 
	
	
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

	public Article getCommandeArticle() {
		return commandeArticle;
	}

	public void setCommandeArticle(Article commandeArticle) {
		this.commandeArticle = commandeArticle;
	}
	public String getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(String qteCommande) {
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
	
	public boolean isErrorQte() {
		return errorQte;
	}

	public void setErrorQte(boolean errorQte) {
		this.errorQte = errorQte;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	public String getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(String montantTotal) {
		this.montantTotal = montantTotal;
	}
	

	public Date getDateCmd() {
		return dateCmd;
	}

	public void setDateCmd(Date dateCmd) {
		this.dateCmd = dateCmd;
	}
	
	
	public void addCommande() {
				
		commande = new Commande();
		dateCmd = new Date();
		commande.setClient(commandeClient);
		commande.setArticleCmd(commandeArticle);
		commande.setNotes(commandNotes);
		commande.setDateCmd(dateCmd);
		commande.setQteCmd(Integer.parseInt(qteCommande));
		
		if(commande.getQteCmd() <= ServiceFactory.getArticleService().getQuantite(dateCmd, commandeArticle.getCode())) {
			
			if(ServiceFactory.getCommandeService().createCommande(commande)) {
				setAddsuccess(true);
				
				qteCommande = "";
				commandNotes = "";
				setErrorQte(false);
				
				montantTotal = (commande.getQteCmd() * commande.getArticleCmd().getPrix()) + "";
			}
			else {
				setAddsuccess(false);
				setErrorQte(false);
			}
		}
		else {
			System.out.println("error ici");
			commandeClient = null;
			commandeArticle = null;
			qteCommande = "";
			commandNotes = "";
			setErrorQte(true);
		}
		
	}
}
