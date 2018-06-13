package com.mql.gestionventes.Actions;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.List;
import java.util.ArrayList;
import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "listeArticlesAction")
@RequestScoped
public class ListeArticlesAction {

	private List<Article> listeArticles = new ArrayList<Article>();
	
	
	/**
	 * Methode pour preparer la liste des articles
	 */
	@PostConstruct
	public void init() {
		
		System.out.println("ici");
		listeArticles = ServiceFactory.getArticleService().allArticles();
	}
	
	public List<Article> getListeArticles() {
		return listeArticles;
	}
	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}
	
}
