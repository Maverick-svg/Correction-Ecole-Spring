package fr.adaming.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Etudiant {

	//déclaration de idEtudiant en cléf primaire de la Table Etudiant
	@Id
	@GeneratedValue
	private int idEtudiant;
	private String nom;
	private String prenom;
	private char groupe;
	
	public Etudiant() {
		super();
		
	}

	public Etudiant(String nom, String prenom, char groupe) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.groupe = groupe;
	}

	public int getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(int idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public char getGroupe() {
		return groupe;
	}

	public void setGroupe(char groupe) {
		this.groupe = groupe;
	}

	@Override
	public String toString() {
		return "Etudiant ayant le numero Etudiant = " + idEtudiant + " :  Nom = " + nom + ", Prenom= " + prenom + " appartenant au groupe= " + groupe + "."
				;
	}
	
	
	
}
