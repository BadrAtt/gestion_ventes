package com.mql.gestionventes.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Utils.HibernateUtil;

public class ClientDao implements DAO<Client> {
	
	private Session session;
	
	
	public Client find(int code) {
		
		try{
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Client client = session.get(Client.class, code);
			session.getTransaction().commit();
			
			return client;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}

	public boolean create(Client object) {
		
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

	public boolean update(Client object) {
		
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

	public boolean delete(Client object){
		
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

	public List<Client> getAll(){
		
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		CriteriaQuery<Client> criteriaQuery = session.getCriteriaBuilder().createQuery(Client.class);
        criteriaQuery.from(Client.class);
        List<Client> allClients = session.createQuery(criteriaQuery).getResultList();
        session.getTransaction().commit();
        session.close();
        
		return allClients;
	}
	
	public int getTotalClient(){
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			CriteriaQuery<Client> criteriaQuery = session.getCriteriaBuilder().createQuery(Client.class);
	        criteriaQuery.from(Client.class);
	        int totalClient = session.createQuery(criteriaQuery).getResultList().size();
	        session.getTransaction().commit();
	        session.close();
	        
			return totalClient;
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
		}
		
		return 0;
	}
}
