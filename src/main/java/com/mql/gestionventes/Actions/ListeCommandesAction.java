package com.mql.gestionventes.Actions;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mql.gestionventes.Entity.Commande;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "listeCommandesAction")
@ViewScoped
public class ListeCommandesAction {

	private boolean showdeleteSuccess;
	private List<Commande> listeCommandes= new ArrayList<Commande>();
	private Commande editCommande;	
	/**
	 * Methode pour preparer la liste des Commandes
	 */
	@PostConstruct
	public void init() {
		
		listeCommandes = ServiceFactory.getCommandeService().getAllCommandes();
	}
	
	public boolean isShowdeleteSuccess() {
		return showdeleteSuccess;
	}
	
	public void setShowdeleteSuccess(boolean showdeleteSuccess) {
		this.showdeleteSuccess = showdeleteSuccess;
	}

	public List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public void setListeCommandes(List<Commande> listeCommandes) {
		this.listeCommandes = listeCommandes;
	}

	public Commande getEditCommande() {
		return editCommande;
	}

	public void setEditCommande(Commande editCommande) {
		this.editCommande = editCommande;
	}

	/**
	 * methode pour supprimer une Commande de la liste
	 */
	public void supprimerCommande() {
		ServiceFactory.getCommandeService().deleteCommande(editCommande);
		setShowdeleteSuccess(true);
		listeCommandes = ServiceFactory.getCommandeService().getAllCommandes();
	}
	
}
