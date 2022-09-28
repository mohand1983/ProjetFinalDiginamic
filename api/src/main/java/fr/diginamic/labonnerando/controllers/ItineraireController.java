package fr.diginamic.labonnerando.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.labonnerando.modeles.Itineraire;
import fr.diginamic.labonnerando.services.ItineraireService;
import fr.diginamic.labonnerando.wrappers.Filter;

/**
 *
 * @author Riwan
 *
 */
@RestController
@RequestMapping("/api/itineraire")
@CrossOrigin("http://localhost:4200")
public class ItineraireController {

	@Autowired
	private ItineraireService itineraireService;

	/**
	 *
	 * @return La liste de tous les itinéraires présent en base de données
	 */
	@GetMapping
	public Collection<Itineraire> findAll() {
		return itineraireService.findAll();
	}

	@GetMapping("/sliced")
	public Page<Itineraire> findPage(
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "10") final Integer size) {

		return itineraireService.findPage(page, size);
	}

	/**
	 *
	 * @param filtre
	 * @param page
	 * @param size
	 * @return
	 */
	@PostMapping("/filtered")
	public Page<Itineraire> findFilteredPage(
			@RequestBody final Filter<Itineraire> filtre,
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "10") final Integer size) {

		return itineraireService.findFilteredPage(filtre, page, size);
	}

	@PostMapping("/matching")
	public Page<Itineraire> findMatching(
			@RequestBody final Itineraire itineraire,
			@RequestParam(defaultValue = "0") final Integer page,
			@RequestParam(defaultValue = "10") final Integer size) {

		return itineraireService.findMatching(itineraire, page, size);
	}

	@GetMapping("/{id}")
	public Itineraire findById(@PathVariable final Integer id) {
		return itineraireService.findById(id);
	}
}
