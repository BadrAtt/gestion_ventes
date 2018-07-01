package com.mql.gestionventes.Actions;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean
@RequestScoped
public class StatisticsAction {

	private int totalArticles;
	private int totalClient;
	private int totalUsers;
	private int totalCommandes;
	private List<Article> topArticles;
	private List<Article> articles;
	private List<Utilisateur> users;
	
	private String labels;
	private String nbrarticle;
	private String nomArticle;
	private String qte;
	
	
	public void setTotalArticles(int totalArticles) {
		this.totalArticles = totalArticles;
	}

	public void setTotalClient(int totalClient) {
		this.totalClient = totalClient;
	}

	public void setTotalUsers(int totalUsers) {
		this.totalUsers = totalUsers;
	}

	public void setTotalCommandes(int totalCommandes) {
		this.totalCommandes = totalCommandes;
	}

	public void setTopArticles(List<Article> topArticles) {
		this.topArticles = topArticles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public void setUsers(List<Utilisateur> users) {
		this.users = users;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public void setNbrarticle(String nbrarticle) {
		this.nbrarticle = nbrarticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public void setQte(String qte) {
		this.qte = qte;
	}

	public int getTotalArticles() {
		return ServiceFactory.getArticleService().getTotalArticles();
	}

	public int getTotalClient() {
		return ServiceFactory.getClientService().getTotalClient();
	}

	public int getTotalUsers() {
		return ServiceFactory.getUserService().getTotalUsers();
	}

	public int getTotalCommandes() {
		return ServiceFactory.getCommandeService().getTotalCommande();
	}

	public List<Article> getTopArticles() {
		return ServiceFactory.getArticleService().getTopArticles();
	}

	public List<Article> getArticles() {
		return ServiceFactory.getArticleService().getLastArticles();
	}

	public List<Utilisateur> getUsers() {
		return ServiceFactory.getUserService().getLastUsers();
	}

	public String getLabels() {
		List<String> listedescmd = ServiceFactory.getCommandeService().getDateAndQteCmd();
		return parseLabel(listedescmd);
	}

	public String getNbrarticle() {
		List<String> listedescmd = ServiceFactory.getCommandeService().getDateAndQteCmd();
		return parseData(listedescmd);
	}

	public String getNomArticle() {
		List<String> listedescmd = ServiceFactory.getCommandeService().getArticleAndQteCmd();
		return parseLabel(listedescmd);
	}

	public String getQte() {
		List<String> listedescmd = ServiceFactory.getCommandeService().getArticleAndQteCmd();
		return parseData(listedescmd);
	}

	public String parseLabel(List<String> listedescmd) {

		List<String[]> dtt = new ArrayList<>(); 
		
		for(String dt : listedescmd) {
			dtt.add(dt.split(","));
		}
		
		String data = "";
        
		for(int i = 0; i<dtt.size();i++){
          data+= "\"" + dtt.get(i)[0]+"\"";
          if(i == dtt.size() - 1){
            break;
          }
          data+=",";
        }
		
		return data;
	}
	
	public String parseData(List<String> listedescmd) {
		List<String[]> dtt = new ArrayList<>(); 
		
		for(String dt : listedescmd) {
			dtt.add(dt.split(","));
		}
		
		String data = "";
        
		for(int i = 0; i<dtt.size();i++){
          data+= "" + dtt.get(i)[1]+"";
          if(i == dtt.size() - 1){
            break;
          }
          data+=",";
        }
		
		return data;
	}
}
