package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Etudiant;

public interface IEtudiantService {

	public int saveEtudiant(Etudiant etu);
	
	public List<Etudiant> listEtudiant();
	
	public Etudiant findEtudiant(int idEtudiant);
	
	public int suppEtudiant(int idEtudiant);
}
