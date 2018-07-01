package com.mql.gestionventes.Services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Entity.Inventaire;
import com.mql.gestionventes.Factory.DaoFactory;
import com.mql.gestionventes.Factory.ServiceFactory;

/**
 * La classe service represente  la couche metier de notre application,
 * chaque entité a sa propre classe metier qui permet de faire les differents traitements
 * liés à cette entité
 */

public class ArticleService {

	public Article getArticleByCode(int code) {
		return DaoFactory.getArticleDao().find(code);
	}
	
	public boolean createArticle(Article article) {
		return DaoFactory.getArticleDao().create(article);
	}
	
	/**
	 * 
	 * @param article: l'article a modifer avec des nouveaux informations
	 * @return true ou false
	 */
	
	public boolean updateArticle(Article article) {
		return DaoFactory.getArticleDao().update(article);
	}
	
	public boolean deleteArticle(Article article) {
		return DaoFactory.getArticleDao().delete(article);
	}
	
	public List<Article> allArticles(){
		return DaoFactory.getArticleDao().getAll();
	}
	
	/**
	 * Récupération de la quantité d'article disponible a une date donnée
	 */
	public long getQuantite(Date date, int idArt){
		Inventaire artInv = ServiceFactory.getInventaireService().getLastInv(date, idArt);
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		String minDate = "1900-01-01";
		if(artInv == null){
			artInv = new Inventaire();
			artInv.setQteArt(0);
			try {
				artInv.setDateInv(dateformat.parse(minDate));
			} catch (ParseException e) {
				System.out.println("Error Date : "+e.getMessage());
			}
		}
		long qteArtAch = ServiceFactory.getAchatService().getQuantiteAchete(artInv.getDateInv(), date, idArt);
		long qteArtVte = ServiceFactory.getCommandeService().getQuantiteCommande(artInv.getDateInv(), date, idArt);
		return artInv.getQteArt() + qteArtAch - qteArtVte;
	}
	
	/**
	 * 
	 * Récupération du nombre total des articles
	 */
	public int getTotalArticles() {
		return DaoFactory.getArticleDao().getTotalArticles();
	}
	
	public List<Article> getTopArticles() {
		return DaoFactory.getArticleDao().getTopArticles();
	}
	
	public List<Article> getLastArticles() {
		return DaoFactory.getArticleDao().getLastArticles();
	}
}
