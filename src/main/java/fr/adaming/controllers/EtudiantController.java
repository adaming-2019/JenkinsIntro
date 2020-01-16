package fr.adaming.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.adaming.entities.Etudiant;
import fr.adaming.entities.Formateur;
import fr.adaming.service.IEtudiantService;

@Controller
@RequestMapping(value = "/ecole")
public class EtudiantController {

	// Transformation de l'association uml en java
	@Autowired
	private IEtudiantService etuService;

	private Formateur formateur;

	// Le setter pour l'injection dépendance
	public void setEtuService(IEtudiantService etuService) {
		this.etuService = etuService;
	}

	@PostConstruct
	public void init() {
		this.formateur = new Formateur(1, "a@a.a", "a");

	}

	// La méthode appelée pour convertir les valeurs des params de la req en objet
	// java(date)
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// L'objet webdtabinder sert à faire le lien entre les parms de la req et les
		// objets java
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

		df.setLenient(false);

		binder.registerCustomEditor(Date.class, new CustomDateEditor(df, false));
	}

	@RequestMapping(value = "/liste", method = RequestMethod.GET)
	public ModelAndView afficheListe() {
		// recup de la liste des etudiants du formateur
		List<Etudiant> listeEtudiants = etuService.getAllEtudiant(this.formateur);
		return new ModelAndView("accueil", "etudiants", listeEtudiants);
	}

	@RequestMapping(value = "/afficherAdd", method = RequestMethod.GET)
	public String afficheAjouter(Model model) {
		model.addAttribute("eAdd", new Etudiant());
		return "ajout";
	}

	@RequestMapping(value = "/submitAdd", method = RequestMethod.POST)
	public String soumettreAjouter(Model model, @ModelAttribute("eAdd") Etudiant eIn) {
		// Appel de la méthode service
		Etudiant eOut = etuService.addEtudiant(eIn, this.formateur);
		if (eOut.getId() != 0) {
			List<Etudiant> listeEtudiants = etuService.getAllEtudiant(this.formateur);

			// Mettre à jour la liste
			model.addAttribute("etudiants", listeEtudiants);

			return "accueil";
		} else {
			return "redirect:afficherAdd";
		}
	}

	// fonctionnalité modifier
	@RequestMapping(value = "/afficherUpdate", method = RequestMethod.GET)
	public String afficheModifier(Model model) {
		model.addAttribute("eUpdate", new Etudiant());
		return "modif";
	}

	@RequestMapping(value = "/submitUpdate", method = RequestMethod.POST)
	public String soumettreModifier(Model model, @ModelAttribute("eUpdate") Etudiant eIn) {
		// Appel de la méthode service
		boolean verif = etuService.updateEtudiant(eIn, this.formateur);
		if (verif = true) {
			List<Etudiant> listeEtudiants = etuService.getAllEtudiant(this.formateur);

			// Mettre à jour la liste
			model.addAttribute("etudiants", listeEtudiants);

			return "accueil";
		} else {
			return "redirect:afficherUpdate";
		}

	}

	// fonctionnalité supprimer
	@RequestMapping(value = "/afficherDelete", method = RequestMethod.GET)
	public String afficheSupprimer(Model model) {
		model.addAttribute("eDelete", new Etudiant());
		return "supprimer";
	}

	@RequestMapping(value = "/submitDelete", method = RequestMethod.POST)
	public String soumettreSupprimer(Model model, @ModelAttribute("eDelete") Etudiant eIn) {
		// Appel de la méthode service
		boolean verif = etuService.deleteEtudiant(eIn, this.formateur);
		if (verif = true) {
			List<Etudiant> listeEtudiants = etuService.getAllEtudiant(this.formateur);

			// Mettre à jour la liste
			model.addAttribute("etudiants", listeEtudiants);

			return "accueil";
		} else {
			return "redirect:afficherDelete";
		}
	}

	// Fonctionnalté chercher 1
	@RequestMapping(value = "/afficherFind", method = RequestMethod.GET)
	public String afficheChercher(Model model) {
		model.addAttribute("eFind", new Etudiant());
		return "recherche";
	}

	@RequestMapping(value = "/submitFind", method = RequestMethod.POST)
	public String soumettreChercher(RedirectAttributes rda, Model model, @ModelAttribute("eFind") Etudiant eIn) {
		// Appel de la méthode service
		Etudiant verif = etuService.getEtudiantById(eIn);
		if (verif != null) {

			model.addAttribute("eTrouve", verif);

			return "recherche";
		} else {
			rda.addFlashAttribute("msg", "La suppression a échoué");
			return "redirect:afficherFind";
		}
	}

}
