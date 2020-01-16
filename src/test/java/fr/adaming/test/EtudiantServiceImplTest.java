package fr.adaming.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/application-context.xml"})
public class EtudiantServiceImplTest {
	
	//Injecter la classe servcie
	@Autowired
	private IEtudiantService eService; 

	@Test
	@Ignore
	public void listeEtudiant1() {
		List<Etudiant> listeAttendu; 
		int a = 7; 
		Formateur fIn = new Formateur();
		fIn.setId(1);
		List<Etudiant> listeObtenue = eService.getAllEtudiant(fIn);
		int b = listeObtenue.size(); 
		
		assertEquals(a, b);
		
	}
	
	@Test
	@Ignore
	public void listeEtudiant2() {
		List<Etudiant> listeAttendu; 
		int a = 8; 
		Formateur fIn = new Formateur();
		fIn.setId(1);
		List<Etudiant> listeObtenue = eService.getAllEtudiant(fIn);
		int b = listeObtenue.size(); 
		
		assertNotEquals(a, b);
		
	}
	
	@Test
	@Ignore
	public void addEtudiant1() {
		Etudiant eIn = new Etudiant();
		eIn.setNom("Kaneki");
		eIn.setPrenom("Ken");
		eIn.setDn(null);
		
		Formateur fIn = new Formateur();
		fIn.setId(1);
		
		Etudiant eObtenu = eService.addEtudiant(eIn, fIn);
		assertNotNull(eObtenu);
		
	}
	
	@Test
	@Ignore
	public void addEtudiant2() {
		Etudiant eIn = new Etudiant();
		
		Formateur fIn = new Formateur();
		fIn.setId(1);
		
		Etudiant eObtenu = eService.addEtudiant(eIn, fIn);
		assertNull(eObtenu);
		
	}

	@Test
	@Ignore
	public void updateEtudiant1() {
		
		Etudiant eIn = new Etudiant();
		eIn.setId(7);
		eIn.setNom("Kaneki");
		eIn.setPrenom("Ken");
		eIn.setDn(null);
		
		Formateur fIn = new Formateur();
		fIn.setId(1);
		
		boolean attendu = true;
		boolean obtenu = eService.updateEtudiant(eIn, fIn);
		assertEquals(attendu, obtenu);
		
	}
	@Test
	@Ignore
	public void updateEtudiant2() {
		
		Etudiant eIn = new Etudiant();
		eIn.setId(7);
		eIn.setNom("Kaneki");
		eIn.setPrenom("Ken");
		eIn.setDn(null);
		
		Formateur fIn = new Formateur(); 
		fIn.setId(1);
		
		boolean attendu = false;
		boolean obtenu = eService.updateEtudiant(eIn, fIn);
		assertNotEquals(attendu, obtenu);
		
	}
	
	@Test
	@Ignore
	public void deleteEtudiant1() {
		Etudiant eIn = new Etudiant();
		eIn.setId(23);
		
		Formateur fIn = new Formateur(); 
		fIn.setId(1);
		
		boolean attendu = true; 
		boolean obtenu = eService.deleteEtudiant(eIn, fIn);
		
		assertEquals(attendu, obtenu);
		
	}
	
	@Test
	@Ignore
	public void deleteEtudiant2() {
		Etudiant eIn = new Etudiant();
		eIn.setId(7);
		
		Formateur fIn = new Formateur(); 
		fIn.setId(1);
		
		boolean attendu = false; 
		boolean obtenu = eService.deleteEtudiant(eIn, fIn);
		
		assertEquals(attendu, obtenu);
		
	}
	
	@Test
	@Ignore
	public void getEtudiant1() {
		Etudiant eIn = new Etudiant();
		
		Formateur fIn = new Formateur(); 
		fIn.setId(1);
		
		Etudiant eObtenu = eService.getEtudiantById(eIn);
		assertNull(eObtenu);
		
	}
	@Test 
	@Ignore
	public void getEtudiant2() {
		Etudiant eIn = new Etudiant();
		
		eIn.setId(8);
		
		Etudiant eObtenu = eService.getEtudiantById(eIn);
		assertNotNull(eObtenu);
		
	}
	
	
}
