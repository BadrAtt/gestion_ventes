package com.mql.gestionventes.Actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import com.mql.gestionventes.Entity.Client;
import com.mql.gestionventes.Factory.ServiceFactory;

@ManagedBean(name = "ajoutClient")
@RequestScoped
public class AjoutClientAction {

	private String nomClient;
	private String prenomClient;
	private String telephoneClient;
	private String adresseClient;
	private boolean addSuccess;
	
	public String getNomClient() {
		return nomClient;
	}
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	public String getPrenomClient() {
		return prenomClient;
	}
	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}
	public String getTelephoneClient() {
		return telephoneClient;
	}
	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}
	public String getAdresseClient() {
		return adresseClient;
	}
	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}
	
	public boolean isAddSuccess() {
		return addSuccess;
	}
	public void setAddSuccess(boolean addSuccess) {
		this.addSuccess = addSuccess;
	}
	
	
	public void addClientAction(){
		
		Client client = new Client();
		client.setNomClient(this.nomClient);
		client.setPrenomClient(this.prenomClient);
		client.setNumeroTelephone(this.telephoneClient);
		client.setAdresse(this.adresseClient);
		
		if(ServiceFactory.getClientService().createClient(client)) {
			this.nomClient = "";
			this.prenomClient = "";
			this.telephoneClient = "";
			this.adresseClient = "";
			
			this.addSuccess = true;
		}
		else {
			this.addSuccess = false;
		}
	}
}
