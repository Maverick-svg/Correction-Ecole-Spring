package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.adaming.dao.IEtudiantDAO;
import fr.adaming.model.Etudiant;

//Bean couche service
@Service
public class EtudiantService implements IEtudiantService{

	//création objet depuis interface IEtudiantDAO
	@Autowired
	private IEtudiantDAO daoEtu;
	
	public int saveEtudiant(Etudiant etu) {
		return daoEtu.saveEtudiant(etu);
	}

	public List<Etudiant> listEtudiant() {
		return daoEtu.listEtudiant();
	}

	public Etudiant findEtudiant(int idEtudiant) {	
		return daoEtu.findEtudiant(idEtudiant);
	}

	public int suppEtudiant(int idEtudiant) {
		return daoEtu.suppEtudiant(idEtudiant);
	}

	
}
