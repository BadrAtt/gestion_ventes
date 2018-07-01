package com.mql.gestionventes.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;

@Entity
@Table(name = "ARTICLE", catalog="gestion_ventes")
public class Article implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8375855624337776053L;

	@Id @GeneratedValue
	@Column(name = "ID_ARTICLE")
	private int code;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRIX")
	private int prix;
	
	@OneToMany(mappedBy = "articleCmd", cascade = CascadeType.ALL)
	private Collection<Commande> commandes = new ArrayList<Commande>();// un article peut etre le sujet de plusieurs commandes
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private Collection<Achat> achats = new ArrayList<Achat>();//
	
	@OneToMany(mappedBy = "article", cascade = CascadeType.ALL)
	private Collection<Inventaire> inventaires; // un article peut etre le sujet de plusieurs inventaires
	
	@Transient
	private boolean editable;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
}
