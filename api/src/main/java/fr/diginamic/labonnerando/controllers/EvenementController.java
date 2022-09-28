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

import fr.diginamic.labonnerando.modeles.Evenement;
import fr.diginamic.labonnerando.services.EvenementService;

@RestController
@RequestMapping("/api/evenement")
@CrossOrigin("http://localhost:4200")
public class EvenementController {

	@Autowired
	private EvenementService evenementService;

	/**
	 * 
	 * @return La liste de tous les évènement présent en base de données
	 */
	@GetMapping
	public Collection<Evenement> findAll() {
		return this.evenementService.findAll();
	}

	@GetMapping("/page")
	public Page<Evenement> findPage(@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreEvenement) {

		return this.evenementService.findPage(numeroPage, nombreEvenement);
	}

	@PostMapping("/matching")
	public Page<Evenement> findMatching(@RequestBody Evenement evenement,
			@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombreEvenement) {

		return this.evenementService.findMatching(evenement, numeroPage, nombreEvenement);
	}
}
