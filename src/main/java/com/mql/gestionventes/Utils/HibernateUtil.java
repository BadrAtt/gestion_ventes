package com.mql.gestionventes.Utils;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;


/**
 * cette classe permet de charger le fichier de configuration d'hibernate afin d'établir une connexion physique
 *  avec la base de donnes
 */

public class HibernateUtil {

	public static final SessionFactory sessionFactory;
	public static final SessionFactory stockSessionFactory;
    
    static {
        try {
          
            sessionFactory = new Configuration().configure("com/mql/gestionventes/Config/hibernate_configuration.xml")
            		.buildSessionFactory();
            stockSessionFactory = new Configuration().configure("com/mql/gestionventes/Config/hibernate_stock_cfg.xml")
            		.buildSessionFactory();
            
        } catch (Throwable ex) {
            
            System.err.println("Exception stack Trace ************** begin");
            System.err.println("Hibernate : Initial SessionFactory creation failed. " + ex);
            ex.printStackTrace();
            System.err.println("Exception Stack Trace ********* END");
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

	public static SessionFactory getStockSessionfactory() {
		return stockSessionFactory;
	}
	
    
}