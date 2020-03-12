package fr.adaming.dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ConnexionDB {

	//l'objet factory ==> etablie la connexion 
	private SessionFactory factory= null;
	
	//Instanciation du singleton de la classe ConnexionDB
	private static ConnexionDB instance =null;
	
	//Constructeur par defaut, visiblité = private (non accessible par les autres classes)
	private ConnexionDB() {
		super();
		
	}
	
	//creation de l'objet factory 
	public SessionFactory getFactory() {
		if(factory==null) {
			//on précise le chemin du fichier de configuration
			factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		}
		return factory;
	}
	//creation d'un objet à partir de la structure ConnexionDB (singleton)
	public static ConnexionDB getConnexion() {
		if(instance == null) {
			instance = new ConnexionDB();
		}
		return instance;
	}
	
}
