package com.mql.gestionventes.Actions;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "listeClientsAction")
@ViewScoped
public class ListeClientsAction {

private List<Client> listeClients = new ArrayList<Client>();
	
	private String ediClientNom;
	private String editClientPrenom;
	private String editClientTelephone;
	private String editClientAdresse;
	private Client editClient;
	private Client tempClient = new Client();
	private boolean showSuccess = false;
	private boolean showdeleteSuccess;
	
	
	/**
	 * Methode pour preparer la liste des articles
	 */
	@PostConstruct
	public void init() {
		
		listeClients = ServiceFactory.getClientService().getAllClients();
		
	}
	
	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}

	public String getEdiClientNom() {
		return ediClientNom;
	}

	public void setEdiClientNom(String ediClientNom) {
		this.ediClientNom = ediClientNom;
	}
	public String getEditClientPrenom() {
		return editClientPrenom;
	}

	public void setEditClientPrenom(String editClientPrenom) {
		this.editClientPrenom = editClientPrenom;
	}
	public String getEditClientTelephone() {
		return editClientTelephone;
	}
	public void setEditClientTelephone(String editClientTelephone) {
		this.editClientTelephone = editClientTelephone;
	}
	public String getEditClientAdresse() {
		return editClientAdresse;
	}
	public void setEditClientAdresse(String editClientAdresse) {
		this.editClientAdresse = editClientAdresse;
	}
	public Client getEditClient() {
		return editClient;
	}

	public void setEditClient(Client editClient) {
		this.editClient = editClient;
	}
	public Client getTempClient() {
		return tempClient;
	}
	public void setTempClient(Client tempClient) {
		this.tempClient = tempClient;
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

	/**
	 * methode pour supprimer un Client de la liste
	 */
	public void supprimerClient() {
		
		ServiceFactory.getClientService().deleteClient(editClient);
		setShowdeleteSuccess(true);
		listeClients = ServiceFactory.getClientService().getAllClients();
		setShowSuccess(false);
		setShowdeleteSuccess(true);
	}

	/**
	 * methode pour modifier un Client de la liste
	 */
	public void modifierClient() {
		
		editClient.setEditable(true);
		
		/**
		 * sauvegarde des anciens information en cas d'annulation de la confirmation
		 */
		tempClient.setCode(editClient.getCode());
		tempClient.setNomClient(editClient.getNomClient());
		tempClient.setPrenomClient(editClient.getPrenomClient());
		tempClient.setAdresse(editClient.getAdresse());
		System.out.println("modifier");
	}
	
	/**
	 * confirmation de la modification
	 */
	public void confirmEdit() {
		
		editClient.setEditable(false);
		ServiceFactory.getClientService().updateClient(editClient);
		setShowSuccess(true);
		setShowdeleteSuccess(false);
		System.out.println("confirm edit");
	}
	
	/**
	 * Annulation de la modification
	 */
	public void cancelEdit() {
		
		/**
		 * recuperation des anciens informations
		 */
		editClient.setNomClient(tempClient.getNomClient());
		editClient.setPrenomClient(tempClient.getPrenomClient());
		editClient.setNumeroTelephone(tempClient.getNumeroTelephone());
		editClient.setAdresse(tempClient.getAdresse());
		
		setShowSuccess(false);
		setShowdeleteSuccess(false);
		editClient.setEditable(false);
	}
}
