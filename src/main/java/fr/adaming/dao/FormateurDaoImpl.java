package fr.adaming.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.entities.Formateur;

@Repository
public class FormateurDaoImpl implements IFormateurDao {

	@Autowired
	private SessionFactory sf;

	// Le setter de sf pour l'injection dépendnace (ce n'est pas obligatoire)

	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public Formateur seConnecter(Formateur fIn) {
		// Recup de la session actuelle de hibernate
		Session s = sf.getCurrentSession();

		// ecrire la req HQL (et pas jpql car j'utilise hibernate)
		String req = "FROM Formateur as f WHERE f.mail=:pMail AND f.mdp=:pMdp";
		// Créer un objet de type Query
		Query query = s.createQuery(req);

		// Passage des params
		query.setParameter("pMail", fIn.getMail());
		query.setParameter("pMdp", fIn.getMdp());

		// Envoyer la req et recup du résultat
		Formateur fOut = (Formateur) query.uniqueResult();

		return fOut;
	}

}
