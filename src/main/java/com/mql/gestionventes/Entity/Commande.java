package com.mql.gestionventes.Entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID")
	private Client client; // chaque commande est faite pour un client
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ARTICLE_ID")
	private Article articleCmd; //L'article commandé
	
	@Column(name = "QUANTITE_CMD")
	private int qteCmd; // la quantité commandé

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
	
	
}
