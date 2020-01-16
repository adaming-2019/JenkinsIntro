package fr.adaming.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IEtudiantDao;
import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/application-context.xml" })
public class EtudiantDaoImplTest {

	// Injecter la classDao
	@Autowired
	private IEtudiantDao eDao;

	Formateur fIn;

	@Before
	public void setUp() {
		this.fIn = new Formateur();
		fIn.setId(1);

	}

	@Test
	@Transactional(readOnly = true)
	public void testGetAllEtudiantTaille() {

		int resulAttendu = 6;
		int resultObtenu = eDao.getAllEtudiant(fIn).size();

		assertEquals(resulAttendu, resultObtenu);

	}

	@Test
	@Transactional(readOnly = true)
	public void testGetAllEtudiantNom() {

		String resulAttendu = "Ackerman";
		List<Etudiant> listeE = eDao.getAllEtudiant(fIn);
		String resultObtenu = listeE.get(0).getNom();

		assertEquals(resulAttendu, resultObtenu);

	}

	@Test
	@Transactional(readOnly = true)
	public void testGetAllEtudiantById() {

		Etudiant eIn = new Etudiant();

		eIn.setId(9);

		Etudiant resultObtenu = eDao.getEtudiantById(eIn);

		assertNotNull(resultObtenu);

	}

	@Test
	@Transactional(readOnly = true)
	public void testGetAllEtudiantByIdNom() {

		Etudiant eIn = new Etudiant();

		eIn.setId(9);
		String resultAttendu = ("Erra");

		String resultObtenu = eDao.getEtudiantById(eIn).getNom();

		assertEquals(resultAttendu, resultObtenu);

	}
	
	@Test
	@Transactional
	public void testAddEtudiant() {
		List<Etudiant> listeAvant = eDao.getAllEtudiant(fIn);
		int avant = listeAvant.size();
		
		Etudiant eIn = new Etudiant();
		eIn.setFormateur(fIn);
		eDao.addEtudiant(eIn);
		
		List<Etudiant> listeApres = eDao.getAllEtudiant(fIn);
		int apres = listeApres.size();
		
		assertEquals(avant+1, apres);
		
	}
	@Test
	@Transactional
	public void testUpdateEtudiant() {
		Etudiant eIn = new Etudiant(13,"LeaonHeart", "Annie", null);
		eDao.updateEtudiant(eIn);
		Etudiant eOut = eDao.getEtudiantById(eIn);
		assertEquals(eIn.getNom(), eOut.getNom());
		
	}
	
	
//	@Test
//	@Transactional(readOnly = true)
//	public void testAddEtudiantNom() {
//		Etudiant eIn = new Etudiant ("LEPELTIER", "Emilie", null);
//		
//		Etudiant eOut = eDao.addEtudiant(eIn);
//
//	}

}
