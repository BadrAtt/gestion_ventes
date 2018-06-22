package com.mql.gestionventes.Actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "listeArticlesAction")
@ViewScoped
public class ListeArticlesAction {

	private List<Article> listeArticles = new ArrayList<Article>();
	
	private String editArticleNom;
	private String editArticleDescription;
	private int editArticlePrix;
	private Article editArticle;
	private Article tempArticle = new Article();
	private boolean showSuccess = false;
	private boolean showdeleteSuccess;
	
	
	/**
	 * Methode pour preparer la liste des articles
	 */
	@PostConstruct
	public void init() {
		
		listeArticles = ServiceFactory.getArticleService().allArticles();
		
	}
	
	public List<Article> getListeArticles() {
		return listeArticles;
	}
	public void setListeArticles(List<Article> listeArticles) {
		this.listeArticles = listeArticles;
	}

	
	public String getEditArticleNom() {
		return editArticleNom;
	}
	public void setEditArticleNom(String editArticleNom) {
		this.editArticleNom = editArticleNom;
	}
	public String getEditArticleDescription() {
		return editArticleDescription;
	}
	public void setEditArticleDescription(String editArticleDescription) {
		this.editArticleDescription = editArticleDescription;
	}
	public int getEditArticlePrix() {
		return editArticlePrix;
	}
	public void setEditArticlePrix(int editArticlePrix) {
		this.editArticlePrix = editArticlePrix;
	}
	
	
	public Article getEditArticle() {
		return editArticle;
	}

	public void setEditArticle(Article editArticle) {
		this.editArticle = editArticle;
	}
	
	public boolean isShowSuccess() {
		return showSuccess;
	}

	public void setShowSuccess(boolean showSuccess) {
		this.showSuccess = showSuccess;
	}
	

	public boolean isShowdeleteSuccess() {
		return showdeleteSuccess;
	}

	public void setShowdeleteSuccess(boolean showdeleteSuccess) {
		this.showdeleteSuccess = showdeleteSuccess;
	}

	/**
	 * methode pour supprimer un article de la liste
	 */
	public void supprimerArticle() {
		ServiceFactory.getArticleService().deleteArticle(editArticle);
		setShowdeleteSuccess(true);
		listeArticles = ServiceFactory.getArticleService().allArticles();
		setShowSuccess(false);
	}

	/**
	 * methode pour modifier un article de la liste
	 */
	public void modifierArticle() {
		editArticle.setEditable(true);
		
		/**
		 * sauvegarde des anciens information en cas d'annulation de la confirmation
		 */
		tempArticle.setCode(editArticle.getCode());
		tempArticle.setNom(editArticle.getNom());
		tempArticle.setDescription(editArticle.getDescription());
		tempArticle.setPrix(editArticle.getPrix());
	}
	
	/**
	 * confirmation de la modification
	 */
	public void confirmEdit() {
		
		editArticle.setEditable(false);
		ServiceFactory.getArticleService().updateArticle(editArticle);
		setShowSuccess(true);
	}
	
	/**
	 * Annulation de la modification
	 */
	public void cancelEdit() {
		
		/**
		 * recuperation des anciens informations
		 */
		editArticle.setNom(tempArticle.getNom());
		editArticle.setDescription(tempArticle.getDescription());
		editArticle.setPrix(tempArticle.getPrix());
		editArticle.setEditable(false);
		
		setShowSuccess(false);
		setShowdeleteSuccess(false);
	}
}
