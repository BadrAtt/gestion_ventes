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
@Table(name = "ACHAT", catalog="G_Stock")
public class Achat {

	@Id @GeneratedValue
	@Column(name = "ID_ACHAT")
	private Integer code;
	
	@ManyToOne
	@JoinColumn(name = "ARTICLE_ID")
	private Article article;
	
	@Column(name = "QTE_ACHETE")
	private int qteAchete;
	
	@Column(name = "DATE_RECEPTION")
	private Date dateReception;
	
	public void setCode(Integer code) {
		this.code = code;
	}

	public int getQteAchete() {
		return qteAchete;
	}

	public void setQteAchete(int qteAchete) {
		this.qteAchete = qteAchete;
	}

	public Integer getCode() {
		return code;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public Date getDateReception() {
		return dateReception;
	}

	public void setDateReception(Date dateReception) {
		this.dateReception = dateReception;
	}
	
}
