package com.mql.gestionventes.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "ARTICLE")
public class Article {
	
	@Id @GeneratedValue
	@Column(name = "ID_ARTICLE")
	private int code;
	
	@Column(name = "NOM")
	private String nom;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "PRIX")
	private int prix;
	
	
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
}
