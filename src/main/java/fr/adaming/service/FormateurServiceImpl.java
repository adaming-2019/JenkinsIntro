package fr.adaming.service;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IFormateurDao;
import fr.adaming.entities.Formateur;

@Service("fServiceBean")
@Transactional
public class FormateurServiceImpl implements IFormateurService {

	// transformation de l'association uml en java
	@Autowired
	private IFormateurDao formDao;

	// Le setter pour l'injection dépendance
	public void setFormDao(IFormateurDao formDao) {
		this.formDao = formDao;
	}

	@Override
	public Formateur seConnecter(Formateur fIn) {
		// Appel de la méthode Dao
		return formDao.seConnecter(fIn);
	}

}
