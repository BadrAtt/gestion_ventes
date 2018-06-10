package com.mql.gestionventes.Services;

import java.util.List;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Factory.DaoFactory;

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
}
