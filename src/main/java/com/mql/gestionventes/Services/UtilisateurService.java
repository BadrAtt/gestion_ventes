package com.mql.gestionventes.Services;

import java.util.List;

import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Factory.DaoFactory;

public class UtilisateurService {

	public Utilisateur getUserByCode(int code) {
		return DaoFactory.getUtilisateurDao().find(code);
	}
	
	public boolean createUser(Utilisateur user) {
		return DaoFactory.getUtilisateurDao().create(user);
	}
	
	public boolean updateUser(Utilisateur user) {
		return DaoFactory.getUtilisateurDao().update(user);
	}
	
	public boolean deleteUser(Utilisateur user) {
		return DaoFactory.getUtilisateurDao().delete(user);
	}
	
	public List<Utilisateur> getAllUsers(){
		return DaoFactory.getUtilisateurDao().getAll();
	}
	
	public Utilisateur loginUser(String username, String password) {
		return DaoFactory.getUtilisateurDao().loginUser(username, password);
	}
	
	public int getTotalUsers() {
		return DaoFactory.getUtilisateurDao().getTotalUsers();
	}
	
	public List<Utilisateur> getLastUsers() {
		return DaoFactory.getUtilisateurDao().getLastUsers();
	}
}
