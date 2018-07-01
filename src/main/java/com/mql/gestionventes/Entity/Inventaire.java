package com.mql.gestionventes.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "INVENTAIRE", catalog="G_Stock")
public class Inventaire {

	@Id @GeneratedValue
	@Column(name = "ID_INVENTAIRE")
	private Integer code;
	
	@ManyToOne
	@JoinColumn(name="ARTICLE_ID")
	private Article article;
	
	@Column(name = "QTE_ARTICLE")
	private int qteArt;
	
	@Column(name = "DESC_INVENTAIRE")
	private String descInv;
	
	@Column(name = "DATE_INVENTAIRE")
	private Date dateInv;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public int getQteArt() {
		return qteArt;
	}

	public void setQteArt(int qteArt) {
		this.qteArt = qteArt;
	}

	public String getDescInv() {
		return descInv;
	}

	public void setDescInv(String descInv) {
		this.descInv = descInv;
	}

	public Date getDateInv() {
		return dateInv;
	}

	public void setDateInv(Date dateInv) {
		this.dateInv = dateInv;
	}
}
