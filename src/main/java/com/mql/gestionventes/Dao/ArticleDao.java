package com.mql.gestionventes.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Utils.HibernateUtil;

public class ArticleDao implements DAO<Article> {
	
	private Session session;
	
	
	public Article find(int code) {
		
		try{
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Article article = session.get(Article.class, code);
			session.getTransaction().commit();
			
			return article;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean create(Article object) {
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(object);
			session.getTransaction().commit();
			session.close();
			
			return true;
			
		}catch(HibernateException hEx) {
			
			hEx.printStackTrace();
		}
		
		return false;
	}

	public boolean update(Article object) {
		
		try {
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.update(object);
			session.getTransaction().commit();
			session.close();
			return true;
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
		}
		
		return false;
	}

	public boolean delete(Article object){
		
		try {
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			session.close();
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
		}
		
		return false;
	}

	public List<Article> getAll(){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CriteriaQuery<Article> criteriaQuery = session.getCriteriaBuilder().createQuery(Article.class);
        criteriaQuery.from(Article.class);
        List<Article> allArticles = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        
		return allArticles;
	}

	
	public int getTotalArticles() {

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			CriteriaQuery<Article> criteriaQuery = session.getCriteriaBuilder().createQuery(Article.class);
	        criteriaQuery.from(Article.class);
	        int totalArticles = session.createQuery(criteriaQuery).getResultList().size();
	        session.getTransaction().commit();
	        session.close();
	        
			return totalArticles;
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
			
		}
		return 0;
	}
	
	@SuppressWarnings("unchecked")
	public List<Article> getTopArticles(){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "SELECT a FROM Article a INNER JOIN a.commandes c GROUP BY a.code ORDER BY c.qteCmd";
		List<Article> results = (List<Article>)session.createQuery(hql).list();

        session.getTransaction().commit();
        session.close();
        
		return results;
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Article> getLastArticles(){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "SELECT a FROM Article a ORDER BY a.code DESC";
		List<Article> results = (List<Article>)session.createQuery(hql).setMaxResults(3).list();
		
        session.getTransaction().commit();
        session.close();
       
        
		return results;
	}
}
