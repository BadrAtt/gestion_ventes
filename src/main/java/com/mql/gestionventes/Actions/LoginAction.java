package com.mql.gestionventes.Actions;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

import com.mql.gestionventes.Entity.Utilisateur;
import com.mql.gestionventes.Factory.ServiceFactory;
import com.mql.gestionventes.Utils.SessionUtil;
import com.mql.gestionventes.Utils.StringUtils;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginAction {

	private Utilisateur utilisateur;
	private String userName;
	private String userPassword;
	private boolean loginSuccess;
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	public boolean isLoginSuccess() {
		return loginSuccess;
	}

	public void setLoginSuccess(boolean loginSuccess) {
		this.loginSuccess = loginSuccess;
	}
	public String loginAction() {
		
		utilisateur  = ServiceFactory.getUserService().loginUser(userName, StringUtils.sha256(userPassword));
		if(utilisateur !=null) {
			
			//utilisateur existe
			
			setLoginSuccess(false);
			HttpSession session = SessionUtil.getSession();
			session.setAttribute("userNom", utilisateur.getNom());
			session.setAttribute("userPrenom", utilisateur.getPrenom());
			session.setAttribute("userLogin", utilisateur.getLogin());
			
			return ("index.xhtml?faces-redirect=true");
		}
		else {
			
			//Utilisateur n'existe pas
			setLoginSuccess(true);
		}
		
		return null;
	}
	
	public String deconnecionAction() {
		HttpSession session = SessionUtil.getSession();
		session.invalidate();
		return("login.xhtml");
	}
}
