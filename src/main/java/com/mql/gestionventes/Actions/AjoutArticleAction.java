package com.mql.gestionventes.Actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "ajoutArticle")
@RequestScoped
public class AjoutArticleAction {
	
	private String nomArticle;
	private String descriptionArticle;
	private int prixArticle;
		
	public String getNomArticle() {
		return nomArticle;
	}
	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}
	public String getDescriptionArticle() {
		return descriptionArticle;
	}
	public void setDescriptionArticle(String descriptionArticle) {
		this.descriptionArticle = descriptionArticle;
	}
	public int getPrixArticle() {
		return prixArticle;
	}
	public void setPrixArticle(int prixArticle) {
		this.prixArticle = prixArticle;
	}

	public void addArticleAction() {
		
		Article article = new Article();
		article.setNom(this.nomArticle);
		article.setDescription(this.descriptionArticle);
		article.setPrix(this.prixArticle);
		
		ServiceFactory.getArticleService().createArticle(article);
		
	}
	
}
