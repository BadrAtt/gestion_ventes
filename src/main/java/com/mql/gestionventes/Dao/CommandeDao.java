package com.mql.gestionventes.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

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

}
