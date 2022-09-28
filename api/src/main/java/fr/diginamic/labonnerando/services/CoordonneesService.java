package fr.diginamic.labonnerando.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import fr.diginamic.labonnerando.modeles.Coordonnees;
import fr.diginamic.labonnerando.repositories.CoordonneesRepository;

@Service
public class CoordonneesService {

	@Autowired
	private CoordonneesRepository coordonneesRepository;

	/**
	 * methode permettant de recuperer des coordonnées en base de données associées
	 * à un itineraire
	 *
	 * @param idItineraire      l'id de l'itineraire associé aux coordonnées
	 *                          recuperées
	 * @param numeroPage        le numero de la page des itineraire si trop
	 *                          volumineux
	 * @param nombreCoordonnees le nombre de coordonnées recuperées dans une seul
	 *                          page
	 * @return une page contenant une protion ou la totalité des coordonnées
	 *         demandées
	 */
	public Page<Coordonnees> findLinkedTo(
			final Integer idItineraire,
			final Integer numeroPage,
			final Integer nombreCoordonnees) {

		return coordonneesRepository.findByItineraire_id(
				idItineraire,
				PageRequest.of(numeroPage, nombreCoordonnees));
	}
}
