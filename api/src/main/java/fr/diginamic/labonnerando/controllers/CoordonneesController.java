package fr.diginamic.labonnerando.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.diginamic.labonnerando.modeles.Coordonnees;
import fr.diginamic.labonnerando.services.CoordonneesService;

@RestController
@RequestMapping("/api/coordonnees")
@CrossOrigin("http://localhost:4200")
public class CoordonneesController {

	@Autowired
	private CoordonneesService coordonneesService;

	/**
	 * point d'entrée de lapplication permettant de recuperer des coordonnées
	 * assoccier a un itineraire
	 *
	 * @param idItineraire      recuperé depuis le chemin de la requete http
	 * @param numeroPage        recuperé en parametre de la requete, est definit à
	 *                          la page 0 si non renseigné
	 * @param nombreCoordonnees recuperé depuis les parametre de la requete, est
	 *                          definit a 0 si non renseigné
	 * @return les une portion ou la totalité coordonnées demandées
	 */
	@GetMapping("/{idItineraire}")
	public Page<Coordonnees> findLinkedTo(@PathVariable("idItineraire") final Integer idItineraire,
			@RequestParam(name = "page", defaultValue = "0") final Integer numeroPage,
			@RequestParam(name = "size", defaultValue = "10") final Integer nombreCoordonnees) {

		return coordonneesService.findLinkedTo(idItineraire, numeroPage, nombreCoordonnees);
	}
}
