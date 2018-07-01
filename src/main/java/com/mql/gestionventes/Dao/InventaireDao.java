package com.mql.gestionventes.Dao;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.mql.gestionventes.Entity.Inventaire;
import com.mql.gestionventes.Utils.HibernateUtil;

public class InventaireDao implements DAO<Inventaire> {
	
	private Session session;
	
	
	public Inventaire find(int code) {
		
		try{
			
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			Inventaire Inventaire = session.get(Inventaire.class, code);
			session.getTransaction().commit();
			
			return Inventaire;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean create(Inventaire object) {
		
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

	public boolean update(Inventaire object) {
		
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

	public boolean delete(Inventaire object){
		
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

	public List<Inventaire> getAll(){
		
		session = HibernateUtil.getStockSessionfactory().getCurrentSession();
		session.beginTransaction();
		CriteriaQuery<Inventaire> criteriaQuery = session.getCriteriaBuilder().createQuery(Inventaire.class);
        criteriaQuery.from(Inventaire.class);
        List<Inventaire> allInventaires = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        
		return allInventaires;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Inventaire lastInv(Date date, int artId) {
		String hql = "FROM Inventaire I WHERE I.article.code = :artId AND I.dateInv <= :date ORDER BY I.dateInv DESC";
		try{
			session = HibernateUtil.getStockSessionfactory().getCurrentSession();
			session.beginTransaction();
			
			Query query = session.createQuery(hql);
			query.setParameter("artId", artId);
			query.setParameter("date", date);
			List<Inventaire> invList = query.list();
			
			session.getTransaction().commit();
	        session.close();
	        
	        if (invList.isEmpty()) {
			    return null;
			} else {
			    return invList.get(0);
			}
		}catch(HibernateException ex){
			System.out.println("Error :"+ ex.getMessage());
			return null;
		}
	}

}
