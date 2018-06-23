package com.mql.gestionventes.Actions;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Factory.ServiceFactory;
import com.mql.gestionventes.Utils.StringUtils;


@ManagedBean(name  = "listeUsersAction")
@ViewScoped
public class ListeUsersAction {

	private List<Utilisateur> listeUtilisateurs = new ArrayList<Utilisateur>();
	
	private String editUserNom;
	private String editUserPrenom;
	private String editUserEmail;
	private String editUserPassword;
	private Utilisateur editUtilisateur;
	private String editPassword;
	private boolean showSuccess = false;
	private boolean showdeleteSuccess;
	
	
	@PostConstruct
	public void init() {
		listeUtilisateurs = ServiceFactory.getUserService().getAllUsers();
	}
	
	public List<Utilisateur> getListeUtilisateurs() {
		return listeUtilisateurs;
	}
	public void setListeUtilisateurs(List<Utilisateur> listeUtilisateurs) {
		this.listeUtilisateurs = listeUtilisateurs;
	}
	public String getEditUserNom() {
		return editUserNom;
	}
	public void setEditUserNom(String editUserNom) {
		this.editUserNom = editUserNom;
	}
	public String getEditUserPrenom() {
		return editUserPrenom;
	}
	public void setEditUserPrenom(String editUserPrenom) {
		this.editUserPrenom = editUserPrenom;
	}
	public String getEditUserEmail() {
		return editUserEmail;
	}
	public void setEditUserEmail(String editUserEmail) {
		this.editUserEmail = editUserEmail;
	}
	public String getEditUserPassword() {
		return editUserPassword;
	}
	public void setEditUserPassword(String editUserPassword) {
		this.editUserPassword = editUserPassword;
	}
	public Utilisateur getEditUtilisateur() {
		return editUtilisateur;
	}
	public void setEditUtilisateur(Utilisateur editUtilisateur) {
		this.editUtilisateur = editUtilisateur;
	}
	public boolean isShowSuccess() {
		return showSuccess;
	}
	public void setShowSuccess(boolean showSuccess) {
		this.showSuccess = showSuccess;
	}
	public boolean isShowdeleteSuccess() {
		return showdeleteSuccess;
	}
	public void setShowdeleteSuccess(boolean showdeleteSuccess) {
		this.showdeleteSuccess = showdeleteSuccess;
	}

	public String getEditPassword() {
		return editPassword;
	}

	public void setEditPassword(String editPassword) {
		this.editPassword = editPassword;
	}

	/**
	 * methode pour supprimer un Utilisateur de la liste
	 */
	public void supprimerUtilisateur() {
		ServiceFactory.getUserService().deleteUser(editUtilisateur);
		setShowdeleteSuccess(true);
		listeUtilisateurs = ServiceFactory.getUserService().getAllUsers();
		setShowSuccess(false);
	}

	/**
	 * methode pour modifier un Utilisateur de la liste
	 */
	public void modifierUtilisateur() {
		
		editUtilisateur.setNom(editUserNom);
		editUtilisateur.setPrenom(editUserPrenom);
		editUtilisateur.setLogin(editUserEmail);
		editUtilisateur.setPassword(StringUtils.sha256(editPassword));
		
		if(ServiceFactory.getUserService().updateUser(editUtilisateur)) {
			setShowSuccess(true);
		}
		else{
			setShowSuccess(false);
		}
	}
	
	/**
	 * methode pour charger les info dans une Modal
	 */
	public void setModal() {
		setEditUserNom(editUtilisateur.getNom()); 
		setEditUserPrenom(editUtilisateur.getPrenom());
		setEditUserEmail(editUtilisateur.getLogin());
	}
}
