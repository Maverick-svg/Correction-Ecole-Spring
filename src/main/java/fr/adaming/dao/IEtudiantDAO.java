package fr.adaming.dao;

import java.util.List;

import fr.adaming.model.Etudiant;

public interface IEtudiantDAO {

	public int saveEtudiant(Etudiant etu);
	
	public List<Etudiant> listEtudiant();
	
	public Etudiant findEtudiant(int idEtudiant);
	
	public int suppEtudiant(int idEtudiant);
}
