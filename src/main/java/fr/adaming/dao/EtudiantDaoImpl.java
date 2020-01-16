package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@Repository
public class EtudiantDaoImpl implements IEtudiantDao {

	@Autowired // On peut le mettre sur l'attributu le setters ou le constructeur
	private SessionFactory sf;

	// Le setter de sf pour l'injection d�pendance (ce n'est pas obligatoire)

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public List<Etudiant> getAllEtudiant(Formateur fIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// ecrire la req HQL (et pas jpql car j'utilise hibernate)
		String req = "FROM Etudiant as e WHERE e.formateur.id=:pId ";

		// Cr�er un objet de type Query
		Query query = s.createQuery(req);

		// Passage des param�tre
		query.setParameter("pId", fIn.getId());

		// Envoyer la req et recup du r�sultat
		List<Etudiant> listeEtudiant = query.list();

		return listeEtudiant;
	}

	@Override
	public Etudiant addEtudiant(Etudiant eIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// Ajouter un etudiant
		s.save(eIn);

		return eIn;

	}

	@Override
	public Etudiant getEtudiantById(Etudiant eIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// La m�thode de la session pour ecup l'�tudiant by id
		Etudiant eOut = (Etudiant) s.get(Etudiant.class, eIn.getId());

		return eOut;
	}

	@Override
	public void deleteEtudiant(Etudiant eIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// Supprimer l'etudiant
		s.delete(eIn);

	}

	@Override
	public void updateEtudiant(Etudiant eIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// Modifier l'etudiant
		s.saveOrUpdate(eIn);

	}

}
