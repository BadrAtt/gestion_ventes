package com.mql.gestionventes.Actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Factory.ServiceFactory;
import com.mql.gestionventes.Utils.StringUtils;

@ManagedBean(name = "ajoutUtilisateur")
@RequestScoped
public class AjoutUtilisateurAction {
	
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String emailUtilisateur;
	private String passwordUtilisateur;
	private boolean addSuccess;
	
	public String getNomUtilisateur() {
		return nomUtilisateur;
	}
	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}
	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}
	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}
	public String getEmailUtilisateur() {
		return emailUtilisateur;
	}
	public void setEmailUtilisateur(String emailUtilisateur) {
		this.emailUtilisateur = emailUtilisateur;
	}
	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}
	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}
	
	public boolean isAddSuccess() {
		return addSuccess;
	}
	public void setAddSuccess(boolean addSuccess) {
		this.addSuccess = addSuccess;
	}
	public void addUsreAction() {
		
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(this.nomUtilisateur);
		utilisateur.setPrenom(this.prenomUtilisateur);
		utilisateur.setLogin(this.emailUtilisateur);
		utilisateur.setPassword(StringUtils.sha256(passwordUtilisateur));
		
		if(ServiceFactory.getUserService().createUser(utilisateur)) {
			this.addSuccess = true;
			
			this.nomUtilisateur = "";
			this.prenomUtilisateur = "";
			this.emailUtilisateur = "";
			this.passwordUtilisateur = "";
		}
		else {
			this.addSuccess = false;
		}
	}
	
}
