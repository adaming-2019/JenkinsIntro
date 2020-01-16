package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.dao.IFormateurDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Service("eServiceBean")
@Transactional
public class EtudiantServiceImpl implements IEtudiantService {

	// transformation de l'association uml en java
	@Autowired
	private IEtudiantDao etuDao;

	// Le setter pour l'injection dépendance
	public void setEtuDao(IEtudiantDao etuDao) {
		this.etuDao = etuDao;

	}

	@Override
	public List<Etudiant> getAllEtudiant(Formateur Fin) {
		return etuDao.getAllEtudiant(Fin);
	}

	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		return etuDao.getEtudiantById(eIn);
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn, Formateur fIn) {
		eIn.setFormateur(fIn);
		return etuDao.addEtudiant(eIn);
	}

	@Override
	public boolean deleteEtudiant(Etudiant eIn, Formateur fIn) {
		// recup de l'etudiant
		Etudiant eOut = etuDao.getEtudiantById(eIn);

		if (eOut != null && fIn.getId() == eOut.getFormateur().getId()) {
			// Appel de la méthode dao pour supprimer
			etuDao.deleteEtudiant(eOut);
			return true;
		}
		return false;

	}

	@Override
	public boolean updateEtudiant(Etudiant eIn, Formateur fIn) {
		// recup de l'etudiant
		Etudiant eOut = etuDao.getEtudiantById(eIn);

		if (eOut != null && fIn.getId() == eOut.getFormateur().getId()) {
			eOut.setNom(eIn.getNom());
			eOut.setPrenom(eIn.getPrenom());
			eOut.setDn(eIn.getDn());

			// Appel de la méthode dao pour supprimer
			etuDao.updateEtudiant(eOut);
			return true;
		}
		return false;
	}

}
