package fr.diginamic.labonnerando.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.labonnerando.modeles.Utilisateur;
import fr.diginamic.labonnerando.services.UtilisateurService;

/**
 * 
 * @author Veronique
 *
 */

@RestController
@RequestMapping("/api/utilisateur")
@CrossOrigin("http://localhost:4200")
public class UtilisateurController {

	@Autowired
	private UtilisateurService utilisateurService;

	/**
	 * 
	 * @return La liste de tous les utilisateurs présents en base de données
	 */
	@GetMapping
	public Collection<Utilisateur> findAll() {
		return this.utilisateurService.findAll();
	}

	@GetMapping("/page")
	public Page<Utilisateur> findPage(@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreUtilisateur) {

		return this.utilisateurService.findPage(numeroPage, nombreUtilisateur);
	}

	@PostMapping("/matching")
	public Page<Utilisateur> findMatching(@RequestBody Utilisateur utilisateur,
			@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreUtilisateur) {

		return this.utilisateurService.findMatching(utilisateur, numeroPage, nombreUtilisateur);
	}
}
