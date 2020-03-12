package Main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.adaming.model.Etudiant;
import fr.adaming.service.IEtudiantService;

public class Main {

	public static void main(String[] args) {
		
		//création d'un objet "bob" de recuperation des Beans
		//via les annotation @service (EtudiantService) et @Repository (EtudiantDAO)
		AnnotationConfigApplicationContext bob = new AnnotationConfigApplicationContext();
		//recherche des Beans en fonction du package
		bob.scan("fr.adaming.dao");
		bob.scan("fr.adaming.service");
		//prise en compte des Beans
		bob.refresh();
		
		//spring effectue l'instanciation d'un objet "etuServ" depuis le Bean "etudiantService"
		IEtudiantService etuServ = (IEtudiantService) bob.getBean("etudiantService");
		
		//creation etudiant
		etuServ.saveEtudiant(new Etudiant("Bruxelles", "Leon", 'a'));
		//listing des etudiant
		System.out.println(etuServ.listEtudiant());
		//trouver un étudiant par son id
		System.out.println(etuServ.findEtudiant(2));
		//supprimer un étudiant par son id
		etuServ.suppEtudiant(1);
	}

}
