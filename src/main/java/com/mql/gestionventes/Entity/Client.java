package com.mql.gestionventes.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CLIENT", catalog="gestion_ventes")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5990896704470700891L;

	@Id @GeneratedValue
	@Column(name = "ID_CLIENT")
	private int code;
	
	@Column(name = "NOM")
	private String nomClient;
	
	@Column(name = "PRENOM")
	private String prenomClient;
	
	@Column(name = "TELEPHONE")
	private String numeroTelephone;
	
	@Column(name = "ADRESSE")
	private String adresse;
	
	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private Collection<Commande> commandes = new ArrayList<Commande>();// les commandes d'un client
	
	@Transient
	private boolean editable;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
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
	public String getNumeroTelephone() {
		return numeroTelephone;
	}
	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	public Collection<Commande> getCommandes() {
		return commandes;
	}
	public void setCommandes(Collection<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
