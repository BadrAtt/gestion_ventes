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
	private String prixArticle;
	private boolean showSuccess = false;
		
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
	
	public String getPrixArticle() {
		return prixArticle;
	}
	public void setPrixArticle(String prixArticle) {
		this.prixArticle = prixArticle;
	}
	
	public boolean isShowSuccess() {
		return showSuccess;
	}
	public void setShowSuccess(boolean showSuccess) {
		this.showSuccess = showSuccess;
	}
	public void addArticleAction() {
		
		Article article = new Article();
		article.setNom(this.nomArticle);
		article.setDescription(this.descriptionArticle);
		article.setPrix(Integer.parseInt(this.prixArticle));
		
		if(ServiceFactory.getArticleService().createArticle(article)) {
			
			this.nomArticle = "";
			this.descriptionArticle = "";
			this.prixArticle = "";
			this.showSuccess = true;
		}
		else {
		}
	}
	
}
