package com.mql.gestionventes.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mql.gestionventes.Entity.Article;
import com.mql.gestionventes.Entity.Commande;
import com.mql.gestionventes.Utils.HibernateUtil;

public class CommandeDao implements DAO<Commande> {

	private Session session;
	
	public Commande find(int code) {
		
		try{
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Commande commande = session.get(Commande.class, code);
			session.getTransaction().commit();
			
			return commande;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean create(Commande object) {
		
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

	public boolean update(Commande object) {
		
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

	public boolean delete(Commande object){
		
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

	public List<Commande> getAll(){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CriteriaQuery<Commande> criteriaQuery = session.getCriteriaBuilder().createQuery(Commande.class);
        criteriaQuery.from(Commande.class);
        List<Commande> allCommandes = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        
		return allCommandes;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public long getQuantiteCommande(Date startDate, Date endDate, int artId) {
		String hql = "SELECT SUM(C.qteCmd) FROM Commande C WHERE C.articleCmd.code = :artId AND C.dateCmd BETWEEN :startDate AND :endDate GROUP BY C.code";
		try{
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("artId", artId);
			query.setParameter("startDate", startDate);
			query.setParameter("endDate", endDate);
			List<Long> qte = query.list();
			
			session.getTransaction().commit();
	        session.close();
	        
	        if (qte.isEmpty()) {
			    	return 0;
			} else {
			    return qte.get(0);
			}
		}catch(HibernateException ex){
			System.out.println("Error :"+ ex.getMessage());
			return 0;
		}
	}
	
	public int getTotalCommande(){
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			CriteriaQuery<Commande> criteriaQuery = session.getCriteriaBuilder().createQuery(Commande.class);
	        criteriaQuery.from(Commande.class);
	        int totalCommande = session.createQuery(criteriaQuery).getResultList().size();
	        session.getTransaction().commit();
	        session.close();
	        
			return totalCommande;
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
		}
		
		return 0;
	}
	
	public List<String> getDateAndQteCmd(){
		

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "SELECT concat(c.dateCmd, ',', COUNT(DISTINCT c.articleCmd)) as cmd FROM Commande c GROUP BY day(c.dateCmd)";
		List<String> results = (List<String>)session.createQuery(hql).list();

        session.getTransaction().commit();
        session.close();
        
		return results;
		
	}
	
	public List<String> getArticleAndQteCmd(){
		

		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "SELECT concat(c.articleCmd.nom, ',', SUM(c.qteCmd)) as cmd FROM Commande c GROUP BY c.articleCmd.code";
		List<String> results = (List<String>)session.createQuery(hql).list();

        session.getTransaction().commit();
        session.close();
        
		return results;
		
	}
	
}
