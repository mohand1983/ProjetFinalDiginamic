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

import fr.diginamic.labonnerando.modeles.PointInteret;
import fr.diginamic.labonnerando.services.PointInteretService;

/**
 * 
 * @author Gontran Elle permet de lister tous les point d'intéret liés à
 *         plusieurs itinéraires et utilisateurs
 *
 *
 */
@RestController
@RequestMapping("/api/point_interet")
@CrossOrigin("http://localhost:4200")
public class PointInteretController {

	@Autowired
	private PointInteretService pointInteretService;

	/**
	 * 
	 * @return La liste de tous les points d'interet présent en base de données
	 */
	@GetMapping
	public Collection<PointInteret> findAll() {
		return this.pointInteretService.findAll();
	}

	@GetMapping("/page")
	public Page<PointInteret> findPage(@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombrePointInteret) {

		return this.pointInteretService.findPage(numeroPage, nombrePointInteret);
	}

	@PostMapping("/matching")
	public Page<PointInteret> findMatching(@RequestBody PointInteret pointInteret,
			@RequestParam(name = "page", value = "0") Integer numeroPage,
			@RequestParam(name = "size", value = "10") Integer nombrePointInteret) {

		return this.pointInteretService.findMatching(pointInteret, numeroPage, nombrePointInteret);
	}
}
