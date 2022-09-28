package fr.diginamic.labonnerando.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

import fr.diginamic.labonnerando.modeles.Coordonnees;

@Repository
public interface CoordonneesRepository extends JpaRepositoryImplementation<Coordonnees, Integer> {

	/**
	 * cette methode va chercher dans la base de données les coordonnées dont l'id
	 * de l'itineraire correspondant à l'id passé en argument
	 *
	 * requiere egalement un format selon lequel paginer le resultat
	 *
	 * @param idItineraire l'id de l'itineraire accossié au coordonnées
	 * @param pageable     l'element permettant la pagination du resultat de la
	 *                     requete, contient la page recherché et le nombre
	 *                     d'element à afficher par page
	 * @return
	 */
	Page<Coordonnees> findByItineraire_id(Integer idItineraire, Pageable pageable);
}
