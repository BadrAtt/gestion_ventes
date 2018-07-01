package com.mql.gestionventes.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mql.gestionventes.Entity.Achat;
import com.mql.gestionventes.Utils.HibernateUtil;

public class AchatDao implements DAO<Achat> {
	
	private Session session;
	
	
	public Achat find(int code) {
		
		try{
			
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			Achat achat = session.get(Achat.class, code);
			session.getTransaction().commit();
			
			return achat;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean create(Achat object) {
		
		try {
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
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

	public boolean update(Achat object) {
		
		try {
			
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
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

	public boolean delete(Achat object){
		
		try {
			
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			session.delete(object);
			session.getTransaction().commit();
			session.close();
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
		}
		
		return false;
	}

	public List<Achat> getAll(){
		
		session = HibernateUtil.getStockSessionfactory().getCurrentSession();
		session.beginTransaction();
		CriteriaQuery<Achat> criteriaQuery = session.getCriteriaBuilder().createQuery(Achat.class);
        criteriaQuery.from(Achat.class);
        List<Achat> allAchats = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        
		return allAchats;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public long getQuantiteAchete(Date startDate, Date endDate, int idArt) {
		String hql = "SELECT SUM(a.qteAchete) FROM Achat a WHERE a.article.code = :artId AND a.dateReception BETWEEN :startDate AND :endDate GROUP BY a.code";
		try{
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("artId", idArt);
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

}
