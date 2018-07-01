package com.mql.gestionventes.Dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.query.Query;
import org.hibernate.Session;

import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Utils.HibernateUtil;

public class UtilisateurDao implements DAO<Utilisateur> {

	private Session session;
	
	
	public Utilisateur find(int code) {
		
		try{
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			Utilisateur utilisateur = session.get(Utilisateur.class, code);
			session.getTransaction().commit();
			
			return utilisateur;
			
		}catch(HibernateException ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	public boolean create(Utilisateur object) {
		
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

	public boolean update(Utilisateur object) {
		
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

	public boolean delete(Utilisateur object){
		
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

	public List<Utilisateur> getAll(){
		
		try {
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			CriteriaQuery<Utilisateur> criteriaQuery = session.getCriteriaBuilder().createQuery(Utilisateur.class);
	        criteriaQuery.from(Utilisateur.class);
	        List<Utilisateur> allUsers = session.createQuery(criteriaQuery).getResultList();
	        session.getTransaction().commit();
	        session.close();
	        
	       return allUsers;
	        
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return  null;
		}
		
	}
	
	public Utilisateur loginUser(String username, String password) {
		
		/**
		 * Construction d'une requette pour retourner un utilisateur s'il existe
		 * avec le nom d'utilisateur et le mot de pass fourni
		 * si l'utilisateur n'existe pas, le resultat retourné sera null
		 */
		
		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
			CriteriaQuery<Utilisateur> criteriaQuery = criteriaBuilder.createQuery(Utilisateur.class);
			Root<Utilisateur> userRoot = criteriaQuery.from(Utilisateur.class);
			criteriaQuery.select(userRoot);
			criteriaQuery.where(criteriaBuilder.equal(userRoot.get("login"), username),criteriaBuilder.equal(userRoot.get("password"), password));
			Query<Utilisateur> query = session.createQuery(criteriaQuery);
			List <Utilisateur> usersList = query.getResultList();
			
			session.getTransaction().commit();
			session.close();
			
			if (usersList.isEmpty()) {
			    return null;
			} else {
			    return usersList.get(0);
			}
			
		
		}catch(HibernateException ex) {
			
			return null;
		}
        
	}
	
	public int getTotalUsers() {

		try {
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			CriteriaQuery<Utilisateur> criteriaQuery = session.getCriteriaBuilder().createQuery(Utilisateur.class);
	        criteriaQuery.from(Utilisateur.class);
	        int totalUsers = session.createQuery(criteriaQuery).getResultList().size();
	        session.getTransaction().commit();
	        session.close();
	        
			return totalUsers;
			
		}catch(HibernateException hEx) {
			hEx.printStackTrace();
			
		}
		return 0;
        
	}
	
	@SuppressWarnings("unchecked")
	public List<Utilisateur> getLastUsers(){
		
		try {
			
			session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			
			String hql = "SELECT u FROM Utilisateur u ORDER BY u.code DESC";
			List<Utilisateur> results = (List<Utilisateur>)session.createQuery(hql).setMaxResults(3).list();
			
	        session.getTransaction().commit();
	        session.close();
	        
	       return results;
	        
		}catch(HibernateException ex) {
			ex.printStackTrace();
			return  null;
		}
		
	}
}
