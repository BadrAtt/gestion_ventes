package com.mql.gestionventes.Entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 * les Annotations Entity, Table, Column, so sont des annotations lié à hibernate qui permetent
 *  de definir la structure de la table dans la base de données.
 */

@Entity
@Table(name = "COMMANDE")
public class Commande {

	@Id @GeneratedValue
	@Column(name = "ID_COMMANDE")
	private int code;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	private Client client; // chaque commande est faite pour un client, et plusieurs commandes peut etres faites par un client
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ARTICLE_ID")
	private Article articleCmd; //L'article commandé
	
	@Column(name = "QUANTITE_CMD")
	private int qteCmd; // la quantité commandé
	
	@Column(name = "DATE_CMD")
	private Date dateCommande; // la date de la commande
	
	@Column(name = "NOTES")
	private String notes;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Article getArticleCmd() {
		return articleCmd;
	}

	public void setArticleCmd(Article articleCmd) {
		this.articleCmd = articleCmd;
	}

	public int getQteCmd() {
		return qteCmd;
	}

	public void setQteCmd(int qteCmd) {
		this.qteCmd = qteCmd;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}
