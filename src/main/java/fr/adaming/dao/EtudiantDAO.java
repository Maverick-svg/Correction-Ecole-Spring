package fr.adaming.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Etudiant;
//Bean couche DAO
@Repository
public class EtudiantDAO implements IEtudiantDAO{

	//ajouter un etudiant
	public int saveEtudiant(Etudiant etu) {
		try {
		//recuperation de la connexion et ouverture de la session pour commencer la transaction
		Session session = ConnexionDB.getConnexion().getFactory().openSession(); 
		//ouverture et enregistrement sur la DataBase
		session.beginTransaction();
		session.save(etu);
		//sauvegarde et fermeture session
		session.getTransaction().commit();
		session.close();
		return 1;
		}catch(HibernateException e){
			//détail exception
			e.printStackTrace();
		return 0;	
		}
		
	}
	
	//lister les etudiants
	public List<Etudiant> listEtudiant() {
		
		try {
			List<Etudiant> listEtu = new ArrayList<Etudiant>();
			Session session = ConnexionDB.getConnexion().getFactory().openSession(); 
			session.beginTransaction();
			//remplissage du tableau qui recupèrer le resultat de la requête "from etudiant" 
			listEtu= session.createQuery("from Etudiant").list();
			session.close();
			//renvoi du tableau
			return listEtu;
			}catch(HibernateException e){
				//détail exception
				e.printStackTrace();
			return null;	
			}}
	
	//sélectionner un étudiant par son ID
	public Etudiant findEtudiant(int idEtudiant) {
		Session session = ConnexionDB.getConnexion().getFactory().openSession(); 
		session.beginTransaction();
		//création d'une requête selectionnant l'étudiant par l'id dans la base de données
		Query query = session.createQuery("from Etudiant where idEtudiant= :IdSearch");
		query.setParameter("IdSearch", idEtudiant);
		Etudiant etuFind = (Etudiant) query.uniqueResult();
		session.close();
		
		return etuFind;
	}
	
	//supprimer un étudiant par son ID
	public int suppEtudiant(int idEtudiant) {
		Session session = ConnexionDB.getConnexion().getFactory().openSession(); 
		session.beginTransaction();
		//création d'un étudiant, attribution de l'id rechercher dans l'objt etuSupp puis
		//suppression par la méthode session.delete
		Etudiant etuSupp = new Etudiant();
		etuSupp.setIdEtudiant(idEtudiant);
		session.delete(etuSupp);
		session.getTransaction().commit();
		session.close();
		return 1;
	}

}
